package com.tecsup.proyectomovil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.proyectomovil.adapters.PizzaHelpAdapter
import com.tecsup.proyectomovil.models.PizzaHelp

class ActivityPizzaHelp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido_help)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val pizzaList = listOf(
            PizzaHelp("Pizza Americana", "Entregado - 03/01"),
            PizzaHelp("Pizza Margarita", "Entregado - 03/01")
        )

        recyclerView.adapter = PizzaHelpAdapter(pizzaList)
    }
}
