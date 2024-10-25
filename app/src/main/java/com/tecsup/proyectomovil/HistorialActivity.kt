package com.tecsup.proyectomovil

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistorialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)

        findViewById<ImageView>(R.id.volver).apply {
            setOnClickListener {
                startActivity(Intent(this@HistorialActivity, User2Activity::class.java))
                finish()
            }

        }

    }
}
