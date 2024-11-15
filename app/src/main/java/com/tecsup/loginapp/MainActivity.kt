package com.tecsup.loginapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tecsup.loginapp.Adapters.ViewPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encuentra el ViewPager2 y el TabLayout en el layout
        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)

        // Crea el adaptador para el ViewPager
        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        // Configura el TabLayout y el ViewPager2 con el TabLayoutMediator
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // Según la posición del tab, asigna un ícono y un texto
            when (position) {
                0 -> {
                    tab.setIcon(R.drawable.home)  // Ícono para el primer tab
                    tab.text = "Home"  // Texto para el primer tab
                }
                1 -> {
                    tab.setIcon(R.drawable.cart)  // Ícono para el segundo tab
                    tab.text = "Cart"  // Texto para el segundo tab
                }
                2 -> {
                    tab.setIcon(R.drawable.account)  // Ícono para el tercer tab
                    tab.text = "Account"  // Texto para el tercer tab
                }
            }
        }.attach()  // Conecta el TabLayout y el ViewPager2
    }
}
