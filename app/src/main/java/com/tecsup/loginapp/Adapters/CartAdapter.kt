package com.tecsup.loginapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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

    // Método para actualizar la lista de items del carrito
    fun updateCartItems(newCartItems: List<Item>) {
        cartItems.clear()
        cartItems.addAll(newCartItems)
        notifyDataSetChanged()  // Si realmente se necesita recargar todos los datos
    }

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.text_pizza_name)
        private val price: TextView = itemView.findViewById(R.id.text_pizza_price)
        private val image: ImageView = itemView.findViewById(R.id.image_pizza)
        private val quantity: TextView = itemView.findViewById(R.id.text_quantity)
        private val increaseButton: Button = itemView.findViewById(R.id.button_increase)
        private val decreaseButton: Button = itemView.findViewById(R.id.button_decrease)

        // Función para bindear los datos al ViewHolder
        fun bind(item: Item) {
            title.text = item.name
            quantity.text = item.quantity.toString()

            // Recalcular el precio total basado en la cantidad
            val totalPrice = item.price * item.quantity
            price.text = "$${"%.2f".format(totalPrice)}"  // Asegura que el precio sea mostrado con dos decimales

            // Cargar la imagen usando Glide si es una URL
            Glide.with(context)
                .load(item.imageUrl)  // Aquí puede ser una URL si se desea cargar desde la web
                .into(image)

            // Botón para aumentar la cantidad
            increaseButton.setOnClickListener {
                item.quantity++
                updatePriceAndQuantity(item)
            }

            // Botón para disminuir la cantidad
            decreaseButton.setOnClickListener {
                if (item.quantity > 1) {
                    item.quantity--
                    updatePriceAndQuantity(item)
                }
            }
        }

        // Método para actualizar el precio y la cantidad
        private fun updatePriceAndQuantity(item: Item) {
            val totalPrice = item.price * item.quantity
            price.text = "$${"%.2f".format(totalPrice)}"
            quantity.text = item.quantity.toString()
            notifyItemChanged(adapterPosition)  // Notifica solo este ítem
        }
    }
}
