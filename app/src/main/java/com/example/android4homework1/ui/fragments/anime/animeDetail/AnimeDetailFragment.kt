package com.example.android4homework1.ui.fragments.anime.animeDetail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4homework1.utils.Resource
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentAnimeDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment : Fragment(R.layout.fragment_anime_detail) {

    private val binding by viewBinding(FragmentAnimeDetailBinding::bind)
    private val args by navArgs<AnimeDetailFragmentArgs>()
    private val viewModel by activityViewModels<AnimeDetailViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpSubscribes()
    }

    private fun setUpSubscribes() {
        subscribeToCharacter()
    }

    private fun subscribeToCharacter() {
        viewModel.fetchSingleAnime(args.id + 1).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    Log.e("AnimeDetailError", it.message.toString())
                }
                is Resource.Loading -> {
                    Log.e("AnimeDetailLoading", it.message.toString())
                }
                is Resource.Success -> {
                  binding.textView.text = it.data!!.detailData.attributes.description
                }
            }
        }
    }
}