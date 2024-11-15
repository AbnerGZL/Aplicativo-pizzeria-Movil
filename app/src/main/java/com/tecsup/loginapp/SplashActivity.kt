package com.tecsup.loginapp// Asegúrate de reemplazar esto con tu paquete

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.os.Looper
import com.tecsup.loginapp.LoginActivity
import com.tecsup.loginapp.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen2)

        // Encuentra el ImageView y aplica la animación
       /* val logoImageView: ImageView = findViewById(R.id.logoImageView)
        val rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotation)
        logoImageView.startAnimation(rotateAnimation)*/

        // Redirige a la actividad principal después de 3 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish() // Finaliza la SplashActivity
        }, 2000)
    }
}
