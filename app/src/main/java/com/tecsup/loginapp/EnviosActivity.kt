package com.tecsup.loginapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class EnviosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_envios)

        findViewById<ImageView>(R.id.volver).apply {
            setOnClickListener {
                startActivity(Intent(this@EnviosActivity, User2Activity::class.java))
                finish() // Cierra la actividad actual
            }
        }



        findViewById<Button>(R.id.btnTrackOrder).apply {
            setOnClickListener {
                startActivity(Intent(this@EnviosActivity, DetallePedidoActivity::class.java))
                finish() // Cierra la actividad actual
            }
        }
    }
}
