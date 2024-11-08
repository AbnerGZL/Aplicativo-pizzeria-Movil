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

class ItemAdapter(private val itemList: List<Item>, private val context: Context, private val addToCart: (Item) -> Unit) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
        holder.buttonAddToCart.setOnClickListener {
            addToCart(item)
        }
    }

    override fun getItemCount(): Int = itemList.size

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.item_title)
        private val price: TextView = itemView.findViewById(R.id.item_price)
        private val image: ImageView = itemView.findViewById(R.id.item_image)
        val buttonAddToCart: Button = itemView.findViewById(R.id.button_add_to_cart)

        fun bind(item: Item) {
            title.text = item.name
            price.text = "$${item.price}"
            image.setImageResource(item.imageResource)
        }
    }
}
