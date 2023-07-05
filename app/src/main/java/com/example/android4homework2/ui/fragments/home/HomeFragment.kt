package com.example.android4homework2.ui.fragments.home

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4homework2.base.BaseFragment
import com.example.android4homework2.ui.adapters.AnimeViewPager
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentBinding, HomeViewModel>(R.layout.fragment_) {

    override val binding by viewBinding(FragmentBinding::bind)
    override val viewModel: HomeViewModel by viewModels()

    private val fragListNames = listOf(
        "Anime",
        "Manga"
    )

    override fun initialize() {
        val adapter = AnimeViewPager(this)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
                tab.text = fragListNames[pos]
        }.attach()
    }
}