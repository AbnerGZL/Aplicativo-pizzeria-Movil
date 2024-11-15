package com.tecsup.loginapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.loginapp.R
import com.tecsup.loginapp.Models.Pizza

class PizzaAdapter(private val pizzaList: List<Pizza>, private val context: Context) :
    RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>() {

    class PizzaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pizzaName: TextView = itemView.findViewById(R.id.pizzaName)
        val pizzaDescription: TextView = itemView.findViewById(R.id.pizzaDescription)
        val pizzaPrice: TextView = itemView.findViewById(R.id.pizzaPrice)
        val pizzaImage: ImageView = itemView.findViewById(R.id.pizzaImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pizza, parent, false)
        return PizzaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val pizza = pizzaList[position]
        holder.pizzaName.text = pizza.getName()
        holder.pizzaDescription.text = pizza.getDescription()
        holder.pizzaPrice.text = "S/. ${pizza.getPrice()}"

        holder.pizzaImage.setImageResource(pizza.getImageResId())
    }

    override fun getItemCount(): Int = pizzaList.size
}
