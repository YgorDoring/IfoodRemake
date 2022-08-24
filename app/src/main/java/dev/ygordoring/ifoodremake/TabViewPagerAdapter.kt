package dev.ygordoring.ifoodremake

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabViewPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {

    val tabs: Array<Int> = arrayOf(R.string.restaurants, R.string.marketplaces, R.string.drinks)
    val fragments = arrayOf(RestaurantFragment(), MarketplaceFragment(), MarketplaceFragment())

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}

class MarketplaceFragment : Fragment() {}