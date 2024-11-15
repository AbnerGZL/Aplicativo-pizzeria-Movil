package com.tecsup.loginapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.loginapp.Models.Item
import com.tecsup.loginapp.R

class CartAdapter(
    private val context: Context,
    private var cartItems: MutableList<Item>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = cartItems[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = cartItems.size

    fun updateCartItems(newCartItems: List<Item>) {
        cartItems.clear()
        cartItems.addAll(newCartItems)
        notifyDataSetChanged()
    }

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.text_pizza_name)
        private val price: TextView = itemView.findViewById(R.id.text_pizza_price)
        private val image: ImageView = itemView.findViewById(R.id.image_pizza)
        private val quantity: TextView = itemView.findViewById(R.id.text_quantity)
        private val increaseButton: Button = itemView.findViewById(R.id.button_increase)
        private val decreaseButton: Button = itemView.findViewById(R.id.button_decrease)

        fun bind(item: Item) {
            title.text = item.name
            price.text = "S/. ${item.price * item.quantity}"
            image.setImageResource(item.imageResource)
            quantity.text = item.quantity.toString()

            increaseButton.setOnClickListener {
                item.quantity++
                price.text = "S/. ${item.price * item.quantity}"
                quantity.text = item.quantity.toString()
                notifyItemChanged(adapterPosition)
            }

            decreaseButton.setOnClickListener {
                if (item.quantity > 1) {
                    item.quantity--
                    price.text = "S/. ${item.price * item.quantity}"
                    quantity.text = item.quantity.toString()
                }
            }
        }
    }
}