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

class ItemAdapter(private val itemList: List<Item>, private val context: Context) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemTitle: TextView = view.findViewById(R.id.item_title)
        val itemPrice: TextView = view.findViewById(R.id.item_price)
        val itemImage: ImageView = view.findViewById(R.id.item_image)
        val addButton: Button = view.findViewById(R.id.add_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemTitle.text = item.name
        holder.itemPrice.text = "s/.${item.price}"
        holder.itemImage.setImageResource(item.imageResource)
        holder.addButton.setOnClickListener {
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
