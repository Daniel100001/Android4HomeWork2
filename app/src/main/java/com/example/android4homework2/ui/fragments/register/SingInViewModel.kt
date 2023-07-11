package com.example.android4homework2.ui.fragments.register

import androidx.lifecycle.ViewModel
import com.example.android4homework2.data.models.SingInModel2
import com.example.android4homework2.data.repositories.SingInRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SingInViewModel @Inject constructor(
    private val repository: SingInRepository
): ViewModel() {

    fun singIn(singInModel2: SingInModel2) = repository.singIn(singInModel2)

}