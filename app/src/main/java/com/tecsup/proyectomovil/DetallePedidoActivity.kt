package com.tecsup.proyectomovil

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class DetallePedidoActivity : AppCompatActivity() {

    private lateinit var volverButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pedido)

        volverButton = findViewById(R.id.volver)

        volverButton.setOnClickListener {
            val intent = Intent(this@DetallePedidoActivity, EnviosActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
