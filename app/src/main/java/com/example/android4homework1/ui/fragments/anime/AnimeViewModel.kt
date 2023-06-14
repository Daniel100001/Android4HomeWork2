package com.example.android4homework1.ui.fragments.anime

import androidx.lifecycle.ViewModel
import com.example.android4homework1.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val animeRepository: AnimeRepository
) : ViewModel() {

    fun fetchCharacters() = animeRepository.fetchCharacters()
}