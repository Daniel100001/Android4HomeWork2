package com.example.android4homework1.ui.fragments.anime

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4homework1.ui.adapters.AnimeAdapter
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FramgentAnimeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment : Fragment(R.layout.framgent_anime) {

    private val binding by viewBinding(FramgentAnimeBinding::bind)
    private val viewModel by viewModels<MangaViewModel>()
    private val animeAdapter = AnimeAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpSubscribes()
    }

    private fun initialize() {
        binding.animeRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = animeAdapter
        }
    }

    private fun setUpSubscribes() {
        subscribeToCharacter()
    }

    private fun subscribeToCharacter() {
        viewModel.fetchCharacters().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                animeAdapter.submitData(it)

            }
        }
    }
}
