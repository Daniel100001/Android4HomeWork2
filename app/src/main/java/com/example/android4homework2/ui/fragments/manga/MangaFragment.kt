package com.example.android4homework2.ui.fragments.manga

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4homework2.base.BaseFragment
import com.example.android4homework2.ui.adapters.MangaAdapter
import com.example.android4homework2.ui.fragments.FragmentDirections
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
            FragmentDirections.actionFragmentToMangaDetailFragment(id)
        )
    }

    override fun initialize() {
        super.initialize()
        binding.animeRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = mangaAdapter
        }
    }

    override fun setupSubscribes() {
        super.setupSubscribes()
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