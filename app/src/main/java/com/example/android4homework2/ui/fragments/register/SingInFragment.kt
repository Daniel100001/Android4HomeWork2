package com.example.android4homework2.ui.fragments.register

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4homework2.base.BaseFragment
import com.example.android4homework2.data.models.SingInModel2
import com.example.android4homework2.utils.Resource
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentSingInBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SingInFragment :
    BaseFragment<FragmentSingInBinding, SingInViewModel>(R.layout.fragment_sing_in) {
    override val binding by viewBinding(FragmentSingInBinding::bind)
    override val viewModel by viewModels<SingInViewModel>()

    override fun setupListeners() {
        binding.singInButton.setOnClickListener {
            val emailEditText = "danldplayer1@gmail.com"
            val passwordEditText = "p123545567789"
            val singInModel2 = SingInModel2(
                grant_type = "password",
                email = emailEditText,
                password = passwordEditText
            )

            if (emailEditText.isEmpty() || passwordEditText.isEmpty()) {
                Toast.makeText(requireContext(), "Заполните поля", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.singIn(singInModel2).observe(viewLifecycleOwner) {
                    when (it) {
                        is Resource.Error -> {
                            Log.e("error", it.message.toString())
                        }

                        is Resource.Loading -> {
                            Log.e("loading", it.message.toString())
                        }

                        is Resource.Success -> {
                            Log.d("anime", it.message.toString())
                            Log.d("result", it.data.toString())
                        }
                    }
                }
            }
        }
    }
}