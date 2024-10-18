package com.tecsup.proyectomovil

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity

class ActivityOferta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recoger)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ofertas2, menu)
        return true
    }
}