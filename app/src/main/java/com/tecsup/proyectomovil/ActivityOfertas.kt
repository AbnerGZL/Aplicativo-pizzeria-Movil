package com.tecsup.proyectomovil

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tecsup.proyectomovil.models.Product

class ActivityOfertas : AppCompatActivity() {

    private lateinit var recyclerViewOffers: RecyclerView
    private lateinit var recyclerViewCombos: RecyclerView
    private lateinit var recyclerViewDrinks: RecyclerView

    private val offerList = listOf(
        Product("Pizza Americana", 25.00, "local_pizza_americana"),
        Product("Pizza Napolitana", 30.00, "local_pizza_napolitana")
    )
    private val comboList = listOf(
        Product("Combo 1", 40.00, "local_combo_1"),
        Product("Combo 2", 45.00, "local_combo_2")
    )
    private val drinkList = listOf(
        Product("Coca Cola", 5.00, "local_drink_coke"),
        Product("Sprite", 5.00, "local_drink_sprite")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ofertas)

        setupBottomNavigation()
        setupToolbar()
        setupRecyclerViews()
    }

    private fun setupBottomNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_cart -> {
                    startActivity(Intent(this, CartActivity::class.java))
                    true
                }
                R.id.nav_home -> {
                    false
                }
                R.id.nav_account -> {
                    startActivity(Intent(this, User2Activity::class.java))
                    true
                }
                else -> false
            }
        }
    }


    private fun setupToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true)
    }

    private fun setupRecyclerViews() {
        recyclerViewOffers = findViewById(R.id.recyclerViewOffers)
        recyclerViewCombos = findViewById(R.id.recyclerViewCombos)
        recyclerViewDrinks = findViewById(R.id.recyclerViewDrinks)

        recyclerViewOffers.adapter = ProductAdapter(offerList)
        recyclerViewOffers.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerViewCombos.adapter = ProductAdapter(comboList)
        recyclerViewCombos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerViewDrinks.adapter = ProductAdapter(drinkList)
        recyclerViewDrinks.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    class ProductAdapter(private val productList: List<Product>) :
        RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

        class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val productName: TextView = itemView.findViewById(R.id.productName)
            val productPrice: TextView = itemView.findViewById(R.id.productPrice)
            val productImage: ImageView = itemView.findViewById(R.id.productImage)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_product, parent, false)
            return ProductViewHolder(view)
        }

        override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
            val product = productList[position]
            holder.productName.text = product.name
            holder.productPrice.text = "S/. ${product.price}"

            val imageRes = getImageResource(product.imageUrl)
            Glide.with(holder.productImage.context)
                .load(imageRes)
                .into(holder.productImage)
        }

        private fun getImageResource(imageUrl: String): Int {
            return when (imageUrl) {
                "local_pizza_americana" -> R.drawable.pizza
                "local_pizza_napolitana" -> R.drawable.pizza
                "local_combo_1" -> R.drawable.pizza
                "local_combo_2" -> R.drawable.pizza
                "local_drink_coke" -> R.drawable.pizza
                "local_drink_sprite" -> R.drawable.pizza
                else -> R.drawable.pizza
            }
        }

        override fun getItemCount(): Int = productList.size
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ofertas2, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.action_about -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
