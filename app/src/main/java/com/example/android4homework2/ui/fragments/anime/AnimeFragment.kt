package com.example.android4homework2.ui.fragments.anime

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4homework2.base.BaseFragment
import com.example.android4homework2.ui.adapters.AnimeAdapter
import com.example.android4homework2.ui.fragments.home.HomeFragmentDirections
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentAnimeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter(this::onItemClick)

    private fun onItemClick(id: Int) {
        findNavController().navigate(HomeFragmentDirections.actionFragmentToAnimeDetailFragment(id))
    }

    override fun initialize() {
        binding.animeRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = animeAdapter
        }
    }

    override fun refreshData() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout()
        }
    }

    private fun swipeRefreshLayout() {
        binding.swipeRefreshLayout.isRefreshing = true
        lifecycleScope.launch {
            viewModel.fetchAnime().observe(viewLifecycleOwner) {
                lifecycleScope.launch {
                    animeAdapter.submitData(it)
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
            viewModel.fetchAnime().observe(viewLifecycleOwner) {
                lifecycleScope.launch {
                    animeAdapter.submitData(it)
                    Log.e("activity", it.toString())
                }
            }
        }
    }
}