package com.example.android4homework2.ui.fragments.manga.detail

import androidx.lifecycle.ViewModel
import com.example.android4homework2.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailMangaViewModel @Inject constructor(private val repository: MangaRepository) :
    ViewModel() {

    fun fetchMangaById(id: Int) = repository.fetchMangaById(id)
}