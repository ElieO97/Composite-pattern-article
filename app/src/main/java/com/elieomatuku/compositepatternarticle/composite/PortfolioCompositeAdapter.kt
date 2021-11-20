package com.elieomatuku.compositepatternarticle.composite

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


/**
 * Created by elieomatuku on 2021-11-16
 */

class PortfolioCompositeAdapter(private val fragment: PortfolioCompositeFragment) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return fragment.children.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragment.children[position].obtainView()
    }
}