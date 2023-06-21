package com.example.android4homework2.ui.fragments.anime.detail

import android.util.Log
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
        subscribeToAnime()
    }

    private fun subscribeToAnime() {
        viewModel.fetchIdAnime(args.id  + 2).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                    Toast.makeText(requireContext(), "loading", Toast.LENGTH_SHORT).show()
                }
                is Resource.Success -> {
                    Log.e("result", "${args.id}")
                    binding.textView.text = it.data?.animeModel?.attributes?.detail
                    Glide.with(binding.imageView)
                        .load(it.data?.animeModel?.attributes?.posterImage?.original)
                        .into(binding.imageView)
                    binding.textView.text = it.data?.animeModel?.attributes?.title?.nameInEnglish
                }
            }
        }
    }
}

