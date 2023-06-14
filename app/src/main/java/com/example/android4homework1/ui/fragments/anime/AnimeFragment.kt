package com.example.android4homework1.ui.fragments.anime

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4homework1.ui.adapters.AnimeAdapter
import com.example.android4homework1.utils.Resource
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FramgentAnimeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment : Fragment(R.layout.framgent_anime) {

    private val binding by viewBinding(FramgentAnimeBinding::bind)
    private val viewModel by viewModels<AnimeViewModel>()
    private val animeAdapter = AnimeAdapter(this::onItemClick)

    private fun onItemClick(id: String) {
        findNavController().navigate(
            AnimeFragmentDirections.actionCharacterFragmentToAnimeDetailFragment(
                id
            )
        )
    }

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
        viewModel.fetchCharacters().observe(this) {
            when (it) {
                is Resource.Error -> {
                    Log.e("AnimeError", it.message.toString())
                }
                is Resource.Loading -> {
                    Log.e("AnimeLoading", it.message.toString())
                }
                is Resource.Success -> {
                    animeAdapter.submitList(it.data!!.data)
                }
            }
        }
    }
}
