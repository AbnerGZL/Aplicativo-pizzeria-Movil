package com.tecsup.proyectomovil

import com.google.android.material.bottomnavigation.BottomNavigationView
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class UserActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        bottomNavigation = findViewById(R.id.bottomNavigation)
        setupBottomNavigation()

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setOnClickListener {
            startActivity(Intent(this@UserActivity, User2Activity::class.java))
            finish()
        }
    }

    private fun setupBottomNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNavigationView.selectedItemId = R.id.nav_account

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_cart -> {
                    startActivity(Intent(this, CartActivity::class.java))
                    true
                }

                R.id.nav_home -> {
                    startActivity(Intent(this, ActivityOfertas::class.java))
                    true
                }

                R.id.nav_account -> {
                    startActivity(Intent(this, UserActivity::class.java))
                    true
                }

                else -> false
            }
        }
    }
}
