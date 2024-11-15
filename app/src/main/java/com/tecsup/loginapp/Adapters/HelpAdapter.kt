package com.tecsup.loginapp.Adapters

import com.tecsup.loginapp.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HelpAdapter(private val temas: Array<String>) :
    RecyclerView.Adapter<HelpAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_help, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textTema.text = temas[position]
        holder.itemView.setOnClickListener { v: View? -> }
    }

    override fun getItemCount(): Int {
        return temas.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textTema: TextView = itemView.findViewById<TextView>(R.id.textTema)
    }
}