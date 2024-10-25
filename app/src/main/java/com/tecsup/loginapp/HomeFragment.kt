package com.tecsup.loginapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.loginapp.Adapters.ItemAdapter
import com.tecsup.loginapp.Models.Item

class HomeFragment : Fragment() {

    private lateinit var recyclerOfertas: RecyclerView
    private lateinit var recyclerCombos: RecyclerView
    private lateinit var recyclerBebidas: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerOfertas = view.findViewById(R.id.recycler_ofertas)
        recyclerCombos = view.findViewById(R.id.recycler_combos)
        recyclerBebidas = view.findViewById(R.id.recycler_bebidas)

        setUpRecyclerView(recyclerOfertas, getOfertasList())
        setUpRecyclerView(recyclerCombos, getCombosList())
        setUpRecyclerView(recyclerBebidas, getBebidasList())

        return view
    }

    private fun setUpRecyclerView(recyclerView: RecyclerView, itemList: List<Item>) {
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = ItemAdapter(itemList, requireContext())
    }

    private fun getOfertasList(): List<Item> {
        return listOf(
            Item("Pizza Americana", 25.00, R.drawable.pizza),
            Item("Pizza Italiana", 30.00, R.drawable.pizza),
            Item("Pizza Hawaiana", 28.00, R.drawable.pizza)
        )
    }

    // Simular lista de Combos
    private fun getCombosList(): List<Item> {
        return listOf(
            Item("Combo 1", 40.00, R.drawable.pizza),
            Item("Combo 2", 50.00, R.drawable.pizza)
        )
    }

    // Simular lista de Bebidas
    private fun getBebidasList(): List<Item> {
        return listOf(
            Item("Coca Cola", 5.00, R.drawable.pizza),
            Item("Inca Kola", 5.00, R.drawable.pizza)
        )
    }
}
