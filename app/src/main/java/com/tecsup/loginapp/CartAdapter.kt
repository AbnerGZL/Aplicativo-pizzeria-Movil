package com.tecsup.loginapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(
    private val context: Context,
    private val pizzaList: List<Pizza>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pizzaImage: ImageView = view.findViewById(R.id.image_pizza)
        val pizzaName: TextView = view.findViewById(R.id.text_pizza_name)
        val pizzaPrice: TextView = view.findViewById(R.id.text_pizza_price)
        val pizzaQuantity: TextView = view.findViewById(R.id.text_quantity)
        val increaseButton: Button = view.findViewById(R.id.button_increase)
        val decreaseButton: Button = view.findViewById(R.id.button_decrease)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val pizza = pizzaList[position]
        holder.pizzaName.text = pizza.nombre
        holder.pizzaPrice.text = pizza.precioTotal().toString()
        holder.pizzaQuantity.text = pizza.cantidad.toString()
        holder.pizzaImage.setImageResource(pizza.imagenResId)

        holder.increaseButton.setOnClickListener {
            pizza.cantidad++
            holder.pizzaPrice.text = pizza.precioTotal().toString()
            holder.pizzaQuantity.text = pizza.cantidad.toString()
            notifyItemChanged(position)
        }

        holder.decreaseButton.setOnClickListener {
            if (pizza.cantidad > 1) {
                pizza.cantidad--
                holder.pizzaPrice.text = pizza.precioTotal().toString()
                holder.pizzaQuantity.text = pizza.cantidad.toString()
                notifyItemChanged(position)
            }
        }
    }

    override fun getItemCount(): Int = pizzaList.size
}
