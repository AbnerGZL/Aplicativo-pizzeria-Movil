package com.tecsup.loginapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.loginapp.Adapters.CartAdapter
import com.tecsup.loginapp.Models.Pizza

class CartFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cartAdapter: CartAdapter
    private lateinit var pizzaList: MutableList<Pizza>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view_cart)
        recyclerView.layoutManager = LinearLayoutManager(context)

        pizzaList = mutableListOf(
            Pizza("Hawaiana", 25, 1, R.drawable.hawaiana),
            Pizza("Americana", 30, 1, R.drawable.pizza),
            Pizza("Americana", 30, 1, R.drawable.pizza),
            Pizza("Americana", 30, 1, R.drawable.pizza),
            Pizza("Americana", 30, 1, R.drawable.pizza),
            Pizza("Americana", 30, 1, R.drawable.pizza),
            Pizza("Americana", 30, 1, R.drawable.pizza)
        )

        cartAdapter = CartAdapter(requireContext(), pizzaList)
        recyclerView.adapter = cartAdapter

        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
