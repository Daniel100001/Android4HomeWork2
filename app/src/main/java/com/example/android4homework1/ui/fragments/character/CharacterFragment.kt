package com.example.android4homework1.ui.fragments.character

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4homework1.ui.adapters.AnimeAdapter
import com.example.android4homework1.utils.Resource
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentCharacterBinding

class CharacterFragment : Fragment(R.layout.fragment_character) {

    private val binding by viewBinding(FragmentCharacterBinding::bind)
    private val viewModel by activityViewModels<CharacterViewModel>()
    private val animeAdapter = AnimeAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpSubscribes()
        initialize()
    }

    private fun initialize() {
        binding.animeRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = animeAdapter
        }
    }

    private fun setUpSubscribes() {
        subscribeToCharacter()
    }

    private fun subscribeToCharacter() {
        viewModel.fetchCharacters().observe(this) {
            when (it) {
                is Resource.Error -> {
                    Log.e("AnimeError", it.message.toString())
                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    animeAdapter.submitList(it.data?.results)
                    Toast.makeText(requireContext(), it.data?.results.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
