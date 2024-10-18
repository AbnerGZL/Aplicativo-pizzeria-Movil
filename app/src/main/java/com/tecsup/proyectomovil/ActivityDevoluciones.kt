package com.tecsup.proyectomovil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.proyectomovil.R
import com.tecsup.proyectomovil.adapters.PizzaAdapter
import com.tecsup.proyectomovil.models.Pizza

class ActivityDevoluciones : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var pizzaAdapter: PizzaAdapter
    private lateinit var pizzaList: List<Pizza>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_devol)

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
