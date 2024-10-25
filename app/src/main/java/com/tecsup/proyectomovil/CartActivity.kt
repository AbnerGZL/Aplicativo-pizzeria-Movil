package com.tecsup.proyectomovil

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tecsup.proyectomovil.adapters.CartAdapter

class CartActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cartAdapter: CartAdapter
    private lateinit var pizzaList: MutableList<Pizza>
    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        bottomNavigation = findViewById(R.id.bottomNavigation)
        setupBottomNavigation()
        setupRecyclerView()
        setupBottomSheet()
        adjustForSystemBars()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ofertas, menu)
        return true
    }

    private fun setupBottomNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNavigationView.selectedItemId = R.id.nav_cart

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_cart -> {
                    false
                }

                R.id.nav_home -> {
                    startActivity(Intent(this, ActivityOfertas::class.java))
                    true
                }

                R.id.nav_account -> {
                    startActivity(Intent(this, User2Activity::class.java))
                    true
                }

                else -> false
            }
        }
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view_cart)
        recyclerView.layoutManager = LinearLayoutManager(this)

        pizzaList = mutableListOf(
            Pizza("Hawaiana", 25, 1, R.drawable.hawaiana)
        )

        cartAdapter = CartAdapter(this, pizzaList)
        recyclerView.adapter = cartAdapter
    }

    private fun setupBottomSheet() {
        val termsIcon: Button = findViewById(R.id.button_confirm_purchase)
        termsIcon.setOnClickListener {
            showTermsBottomSheet()
        }
    }

    private fun showTermsBottomSheet() {
        val bottomSheetDialog = BottomSheetDialog(this)
        val bottomSheetView = layoutInflater.inflate(R.layout.bottom_sheet_terms_delivery, null)
        bottomSheetDialog.setContentView(bottomSheetView)

        val buttonInStore = bottomSheetView.findViewById<Button>(R.id.button_in_store)
        val buttonDelivery = bottomSheetView.findViewById<Button>(R.id.button_delivery)
        val buttonContinueShopping = bottomSheetView.findViewById<Button>(R.id.button_continue_shopping)

        buttonInStore.setOnClickListener {
            val intent = Intent(this, ActivityOferta::class.java)
            startActivity(intent)
            bottomSheetDialog.dismiss()
        }

        buttonDelivery.setOnClickListener {
            val intent = Intent(this, DeliveryActivity::class.java)
            startActivity(intent)
            bottomSheetDialog.dismiss()
        }

        buttonContinueShopping.setOnClickListener {
            val intent = Intent(this, ActivityOfertas::class.java)
            startActivity(intent)
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.show()
    }

    private fun adjustForSystemBars() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cartLayout)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
