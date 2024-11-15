package com.tecsup.loginapp.Adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tecsup.loginapp.AccountFragment
import com.tecsup.loginapp.CartFragment
import com.tecsup.loginapp.HomeFragment

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> CartFragment()
            2 -> AccountFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}
