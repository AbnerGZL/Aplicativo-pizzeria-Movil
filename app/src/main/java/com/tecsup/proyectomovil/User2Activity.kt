package com.tecsup.proyectomovil

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog

class User2Activity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user2)

        findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar).apply {
            setOnClickListener {
                startActivity(Intent(this@User2Activity, UserActivity::class.java))
                finish()
            }
        }

        val termsIcon: ImageView = findViewById(R.id.terms_icon)
        val enviosIcon: ImageView = findViewById(R.id.envios_icon)
        val usuarioIcon: ImageView = findViewById(R.id.ic_usuario)
        val historialIcon: ImageView = findViewById(R.id.ic_historial)
        val devoIcon: ImageView = findViewById(R.id.ic_devo)
        val ayudaIcon: ImageView = findViewById(R.id.ic_ayuda)
        val pfIcon: ImageView = findViewById(R.id.ic_pf)

        termsIcon.setOnClickListener {
            showTermsBottomSheet()
        }
        usuarioIcon.setOnClickListener {
            val intent = Intent(this@User2Activity, UserActivity::class.java)
            startActivity(intent)
        }
        enviosIcon.setOnClickListener {
            val intent = Intent(this@User2Activity, EnviosActivity::class.java)
            startActivity(intent)
        }

        historialIcon.setOnClickListener {
            val intent = Intent(this@User2Activity, HistorialActivity::class.java)
            startActivity(intent)
        }

        ayudaIcon.setOnClickListener {
            val intent = Intent(this@User2Activity, ActivityPizzaHelp::class.java)
            startActivity(intent)
        }

        devoIcon.setOnClickListener {
            val intent = Intent(this@User2Activity, ActivityDevoluciones::class.java)
            startActivity(intent)
        }

        pfIcon.setOnClickListener {
            val intent = Intent(this@User2Activity, HelpActivity::class.java)
            startActivity(intent)
        }

        setupBottomNavigation()
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
                    false
                }
                else -> false
            }
        }
    }

    private fun showTermsBottomSheet() {
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_terms_conditions)
        bottomSheetDialog.show()
    }
}
