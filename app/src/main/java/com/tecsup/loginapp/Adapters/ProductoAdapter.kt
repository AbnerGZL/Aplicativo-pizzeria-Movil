package com.tecsup.loginapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tecsup.loginapp.R
import com.tecsup.loginapp.Models.Product

class ProductoAdapter(private val productList: List<Product>) : RecyclerView.Adapter<ProductoAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productImage: ImageView = view.findViewById(R.id.productImage)
        val productName: TextView = view.findViewById(R.id.productName)
        val productPrice: TextView = view.findViewById(R.id.productPrice)
        val btnAddToCart: Button = view.findViewById(R.id.btnAddToCart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.productName.text = product.name
        holder.productPrice.text = "S/. ${product.price}"

        if (!product.imageUrl.isNullOrEmpty()) {
            Glide.with(holder.productImage.context)
                .load(product.imageUrl)
                .into(holder.productImage)
        } else {
            holder.productImage.setImageResource(R.drawable.pizza)
        }

        holder.btnAddToCart.setOnClickListener {
            // Manejo de la acción de agregar al carrito
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}
