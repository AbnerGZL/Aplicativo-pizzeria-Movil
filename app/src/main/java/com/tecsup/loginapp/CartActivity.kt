package com.tecsup.loginapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cartAdapter: CartAdapter
    private lateinit var pizzaList: MutableList<Pizza>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cart)

        recyclerView = findViewById(R.id.recycler_view_cart)
        recyclerView.layoutManager = LinearLayoutManager(this)

        pizzaList = mutableListOf(
            Pizza("Hawaiana", 25, 1, R.drawable.hawaiana),
        )

        cartAdapter = CartAdapter(this, pizzaList)
        recyclerView.adapter = cartAdapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cartLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}