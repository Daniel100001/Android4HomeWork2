package com.example.android4homework1.ui.fragments.character

import androidx.lifecycle.ViewModel
import com.example.android4homework1.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel(){

    fun fetchCharacters() = characterRepository.fetchCharacters()
}