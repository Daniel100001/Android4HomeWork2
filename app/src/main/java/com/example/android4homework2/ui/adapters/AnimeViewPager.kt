package com.example.android4homework2.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class AnimeViewPager(
    fa: FragmentActivity, private val list: List<Fragment>
) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }
}