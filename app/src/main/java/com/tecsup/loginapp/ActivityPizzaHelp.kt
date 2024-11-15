package com.tecsup.loginapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.loginapp.Adapters.PizzaHelpAdapter
import com.tecsup.loginapp.Models.PizzaHelp

class ActivityPizzaHelp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido_help)

        findViewById<ImageView>(R.id.volver).apply {
            setOnClickListener {
                startActivity(Intent(this@ActivityPizzaHelp, User2Activity::class.java))
                finish()
            }

        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val pizzaList = listOf(
            PizzaHelp("Pizza Americana", "Entregado - 03/01"),
            PizzaHelp("Pizza Margarita", "Entregado - 03/01")
        )

        recyclerView.adapter = PizzaHelpAdapter(pizzaList)
    }
}
