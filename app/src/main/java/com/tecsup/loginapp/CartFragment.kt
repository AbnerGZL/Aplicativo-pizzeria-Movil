package com.tecsup.loginapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
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

        val buttonConfirmPurchase = view.findViewById<Button>(R.id.button_confirm_purchase)
        buttonConfirmPurchase.setOnClickListener {
            showBottomSheetDialog()
        }
    }

    private fun showBottomSheetDialog() {
        // Inicializa el BottomSheetDialog y le establece el layout personalizado
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        val bottomSheetView = layoutInflater.inflate(R.layout.layout_bottom_sheet, null)
        bottomSheetDialog.setContentView(bottomSheetView)

        // Configura acciones para los botones en el BottomSheet
        val buttonStorePickup = bottomSheetView.findViewById<Button>(R.id.button_store_pickup)
        val buttonDelivery = bottomSheetView.findViewById<Button>(R.id.button_delivery)
        val btnContinueShopping = bottomSheetView.findViewById<Button>(R.id.btn_continue_shopping)

        buttonStorePickup.setOnClickListener {
            // Acción para el botón "Recojo en Tienda"
            bottomSheetDialog.dismiss() // Cierra el BottomSheet
            // Aquí puedes agregar la lógica para el recojo en tienda
        }

        buttonDelivery.setOnClickListener {
            // Acción para el botón "Delivery"
            bottomSheetDialog.dismiss() // Cierra el BottomSheet
            // Aquí puedes agregar la lógica para el delivery
        }

        btnContinueShopping.setOnClickListener {
            // Acción para "Seguir escogiendo pizzas"
            bottomSheetDialog.dismiss() // Cierra el BottomSheet
            // Aquí puedes agregar la lógica para continuar comprando
        }

        bottomSheetDialog.show()
    }

}
