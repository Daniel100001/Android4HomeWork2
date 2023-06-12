package com.example.android4homework1.ui.fragments.character

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4homework1.utils.Resource
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentCharacterBinding

class CharacterFragment : Fragment(R.layout.fragment_character) {

    private val binding by viewBinding(FragmentCharacterBinding::bind)
    private val viewModel by activityViewModels<CharacterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpSubscribes()
    }

    private fun setUpSubscribes() {
        viewModel.fetchCharacters().observe(this){
            when(it){
                is Resource.Error -> {
                    binding.text.text = "dan"

                    Toast.makeText(requireContext(), it.message.toString(), Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                    binding.text.text = "hjggkjgb"

                }
                is Resource.Success -> {
                    Log.e("anime", it.data.toString())
                    binding.text.text = "tima"
                }
            }
        }
    }
}
