package com.example.android4homework2.ui.fragments.manga

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4homework2.base.BaseFragment
import com.example.android4homework2.ui.adapters.MangaAdapter
import com.example.android4homework2.ui.fragments.home.HomeFragmentDirections
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentMangaBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment : BaseFragment<FragmentMangaBinding, MangaViewModel>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel: MangaViewModel by viewModels()
    private val mangaAdapter = MangaAdapter(this::onItemClick)

    private fun onItemClick(id: Int) {
        findNavController().navigate(
            HomeFragmentDirections.actionFragmentToMangaDetailFragment(id)
        )
    }

    override fun initialize() {
        binding.animeRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = mangaAdapter
        }
    }

    override fun refreshData() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            pon()
        }
    }

    private fun pon() {
        binding.swipeRefreshLayout.isRefreshing = true
        lifecycleScope.launch {
            viewModel.fetchManga().observe(viewLifecycleOwner) {
                lifecycleScope.launch {
                    mangaAdapter.submitData(it)
                    Log.e("activity", it.toString())
                }
            }
        }
        binding.swipeRefreshLayout.isRefreshing = false
    }

    override fun setupSubscribes() {
        subscribeToAnime()
    }

    private fun subscribeToAnime() {
        lifecycleScope.launch {
            viewModel.fetchManga().observe(viewLifecycleOwner) {
                lifecycleScope.launch {
                    mangaAdapter.submitData(it)
                }
            }
        }
    }
}