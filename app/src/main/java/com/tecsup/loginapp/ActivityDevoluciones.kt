package com.tecsup.loginapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.loginapp.R
import com.tecsup.loginapp.Adapters.PizzaAdapter
import com.tecsup.loginapp.Models.Pizza

class ActivityDevoluciones : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var pizzaAdapter: PizzaAdapter
    private lateinit var pizzaList: List<Pizza>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_devol)

        findViewById<ImageView>(R.id.volver).apply {
            setOnClickListener {
                startActivity(Intent(this@ActivityDevoluciones, User2Activity::class.java))
                finish()
            }

        }

        recyclerView = findViewById(R.id.recyclerViewDevoluciones)
        recyclerView.layoutManager = LinearLayoutManager(this)

        pizzaList = listOf(
            Pizza("Pizza Americana", "Oferta solo por el día festivo, una pizza grande a mitad de precio.", 25.00, "1", R.drawable.pizza),
            Pizza("Pizza Pepperoni", "Deliciosa pizza con pepperoni.", 30.00, "1", R.drawable.pizza),
            Pizza("Pizza Pepperoni", "Deliciosa pizza con pepperoni.", 30.00, "1", R.drawable.pizza),
            Pizza("Pizza Pepperoni", "Deliciosa pizza con pepperoni.", 30.00, "1", R.drawable.pizza),
            Pizza("Pizza Pepperoni", "Deliciosa pizza con pepperoni.", 30.00, "1", R.drawable.pizza),
            Pizza("Pizza Pepperoni", "Deliciosa pizza con pepperoni.", 30.00, "1", R.drawable.pizza)

        )

        pizzaAdapter = PizzaAdapter(pizzaList, this)
        recyclerView.adapter = pizzaAdapter
    }
}
