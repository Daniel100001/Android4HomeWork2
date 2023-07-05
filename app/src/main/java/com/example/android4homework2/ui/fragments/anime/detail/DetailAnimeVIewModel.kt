package com.example.android4homework2.ui.fragments.anime.detail

import androidx.lifecycle.ViewModel
import com.example.android4homework2.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailAnimeVIewModel @Inject constructor(private val repository: AnimeRepository) :
    ViewModel() {

    fun fetchIdAnime(id: Int) = repository.fetchSingleAnime(id)
}