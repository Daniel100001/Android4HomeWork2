package com.example.android4homework2.ui.fragments.anime.detail

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.android4homework2.base.BaseFragment
import com.example.android4homework2.utils.Resource
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentAnimeDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailAnimeFragment :
    BaseFragment<FragmentAnimeDetailBinding, DetailAnimeVIewModel>(R.layout.fragment_anime_detail) {

    override val binding by viewBinding(FragmentAnimeDetailBinding::bind)
    override val viewModel: DetailAnimeVIewModel by viewModels()
    private val args by navArgs<DetailAnimeFragmentArgs>()

    override fun setupSubscribes() {
        subscribeToManga()
    }

    private fun subscribeToManga() {
        viewModel.fetchIdAnime(args.id).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                    Toast.makeText(requireContext(), "loading", Toast.LENGTH_SHORT).show()
                }
                is Resource.Success -> {
                    Glide.with(binding.imageView)
                        .load(it.data?.animeModel?.attributes?.posterImage?.original)
                        .into(binding.imageView)
                    binding.name.text = it.data?.animeModel?.attributes?.title?.nameInEnglish
                    binding.description.text = it.data?.animeModel?.attributes?.description
                }
            }
        }
    }
}

