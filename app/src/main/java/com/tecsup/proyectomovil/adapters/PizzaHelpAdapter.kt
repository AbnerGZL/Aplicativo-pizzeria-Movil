package com.tecsup.proyectomovil.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.proyectomovil.R
import com.tecsup.proyectomovil.models.PizzaHelp

class PizzaHelpAdapter(private val pizzaList: List<PizzaHelp>) : RecyclerView.Adapter<PizzaHelpAdapter.PizzaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pizza_help, parent, false)
        return PizzaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val pizza = pizzaList[position]
        holder.bind(pizza)
    }

    override fun getItemCount(): Int = pizzaList.size

    // ViewHolder interno
    class PizzaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgPizza: ImageView = itemView.findViewById(R.id.imgPizza)
        private val textPizzaTitle: TextView = itemView.findViewById(R.id.textPizzaTitle)
        private val textPizzaSubtitle: TextView = itemView.findViewById(R.id.textPizzaSubtitle)

        fun bind(pizza: PizzaHelp) {
            textPizzaTitle.text = pizza.title
            textPizzaSubtitle.text = pizza.statusAndDate
            imgPizza.setImageResource(R.drawable.pizza)
        }
    }
}

