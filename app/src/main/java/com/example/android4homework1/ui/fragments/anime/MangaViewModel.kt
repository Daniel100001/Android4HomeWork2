package com.example.android4homework1.ui.fragments.anime

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.android4homework1.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MangaViewModel @Inject constructor(
    private val mangaRepository: MangaRepository
) : ViewModel() {

    fun fetchCharacters() = mangaRepository.fetchCharacters().cachedIn(viewModelScope)
}