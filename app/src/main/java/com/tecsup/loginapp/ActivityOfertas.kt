package com.tecsup.loginapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import com.tecsup.loginapp.Models.Product
import com.tecsup.loginapp.Retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivityOfertas : AppCompatActivity() {
    private lateinit var recyclerViewOffers: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private val productList = mutableListOf<Product>()  // Lista mutable para los productos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ofertas)

        setupToolbar()           // Configurar la barra de herramientas
        setupRecyclerView()      // Configurar el RecyclerView
        fetchProductsFromApi()   // Cargar productos de la API
    }

    private fun fetchProductsFromApi() {
        RetrofitClient.instance.getProducts().enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    response.body()?.let { products ->
                        productList.clear() // Limpiar la lista actual
                        productList.addAll(products) // Agregar nuevos productos
                        productAdapter.notifyDataSetChanged()
                        Log.d("API Response", products.toString())
                    }
                } else {
                    Log.e("API Response", "Error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                // Manejo de errores de conexión (puedes agregar un Toast o Log aquí)
            }
        })
    }


    private fun setupToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar) // Configurar la barra de herramientas como soporte
        supportActionBar?.setDisplayShowTitleEnabled(true) // Mostrar el título
    }

    private fun setupRecyclerView() {
        recyclerViewOffers = findViewById(R.id.recyclerViewOffers)
        productAdapter = ProductAdapter(productList) // Inicializar el adaptador
        recyclerViewOffers.adapter = productAdapter
        recyclerViewOffers.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) // Configurar el layout manager
    }

    // Adaptador para el RecyclerView
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

            // Usa Glide para cargar la imagen del producto
            Glide.with(holder.productImage.context)
                .load(product.imageUrl)
                .into(holder.productImage)
        }

        override fun getItemCount(): Int = productList.size // Retorna la cantidad de productos
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ofertas2, menu) // Inflar el menú
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