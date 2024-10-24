package com.tecsup.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog

class UserActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user2)

        findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar).apply {
            setOnClickListener {
                startActivity(Intent(this@UserActivity, MainActivity::class.java))
                finish()
            }
        }
        val termsIcon: ImageView = findViewById(R.id.terms_icon)
        val enviosIcon: ImageView = findViewById(R.id.envios_icon)
        val historialIcon: ImageView = findViewById(R.id.ic_historial)

        termsIcon.setOnClickListener {
            showTermsBottomSheet()
        }

        enviosIcon.setOnClickListener {
            val intent = Intent(this@UserActivity, EnviosActivity::class.java)
            startActivity(intent)
        }

        historialIcon.setOnClickListener {
            val intent = Intent(this@UserActivity, HistorialActivity::class.java)
            startActivity(intent)
        }
    }
    private fun showTermsBottomSheet() {
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_terms_conditions)
        bottomSheetDialog.show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }



}