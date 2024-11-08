package com.tecsup.loginapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.loginapp.Adapters.CartAdapter

class CartFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cartAdapter: CartAdapter
    private lateinit var cartViewModel: CartViewModel

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

        cartViewModel = ViewModelProvider(requireActivity()).get(CartViewModel::class.java)

        cartAdapter = CartAdapter(requireContext(), mutableListOf())
        recyclerView.adapter = cartAdapter

        cartViewModel.cartItems.observe(viewLifecycleOwner) { items ->
            cartAdapter.updateCartItems(items)
        }
    }
}
