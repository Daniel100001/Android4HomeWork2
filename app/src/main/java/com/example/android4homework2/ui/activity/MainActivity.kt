package com.example.android4homework2.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.android4homework2.ui.adapters.AnimeAdapter
import com.example.android4homework2.ui.adapters.AnimeViewPager
import com.example.android4homework2.ui.fragments.anime.AnimeFragment
import com.example.android4homework2.ui.fragments.manga.MangaFragment
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var animeFragment=  AnimeFragment()
    private var mangaFragment =  MangaFragment()

    private val fragList = listOf(
        animeFragment,
        mangaFragment
    )
    private val fragListNames = listOf(
        "Anime",
        "Manga"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize()
        setUpNav()
    }

    private fun initialize() {
        val adapter = AnimeViewPager(this, fragList)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager){
                tab,pos -> tab.text = fragListNames[pos]
        }.attach()
    }

    private fun setUpNav(){
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)
    }
}