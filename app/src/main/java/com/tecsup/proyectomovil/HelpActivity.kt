package com.tecsup.proyectomovil

import com.tecsup.proyectomovil.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.proyectomovil.HelpActivity
import com.tecsup.proyectomovil.adapters.HelpAdapter


class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewAyuda)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val temas =
            arrayOf("Tema 1", "Tema 2", "Tema 3", "Tema 4", "Tema 5", "Tema 6", "Tema 7", "Tema 8")
        val adapter = HelpAdapter(temas)
        recyclerView.adapter = adapter
    }
}