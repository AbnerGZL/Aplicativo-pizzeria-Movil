package com.tecsup.loginapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tecsup.loginapp.Adapters.ViewPagerAdapter
import com.tecsup.loginapp.Models.Cliente
import com.tecsup.loginapp.Retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.navigation_view)
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )

        toggle.drawerArrowDrawable.setColor(ContextCompat.getColor(this, R.color.white))

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.Inicio -> {
                    R.layout.fragment_home
                }
                R.id.Compras -> {
                    R.layout.activity_historial
                }
                R.id.Pedidos -> {
                    R.layout.activity_historial
                }
                R.id.Cuenta -> {
                    R.layout.fragment_account
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // Encuentra el ViewPager2 y el TabLayout en el layout
        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)

        // Crea el adaptador para el ViewPager
        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        // Configura el TabLayout y el ViewPager2 con el TabLayoutMediator
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // Según la posición del tab, asigna un ícono y un texto
            when (position) {
                0 -> {
                    tab.setIcon(R.drawable.home)  // Ícono para el primer tab
                    tab.text = "Home"  // Texto para el primer tab
                }
                1 -> {
                    tab.setIcon(R.drawable.cart)  // Ícono para el segundo tab
                    tab.text = "Cart"  // Texto para el segundo tab
                }
                2 -> {
                    tab.setIcon(R.drawable.account)  // Ícono para el tercer tab
                    tab.text = "Account"  // Texto para el tercer tab
                }
            }
        }.attach()  // Conecta el TabLayout y el ViewPager2

        cargarDatosUsuario()
    }

    private fun cargarDatosUsuario() {
        val sharedPreferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username", null)

        if (username != null) {
            val clienteService = RetrofitClient.instance

            val headerView = findViewById<NavigationView>(R.id.navigation_view).getHeaderView(0)
            val userNameTextView = headerView.findViewById<TextView>(R.id.UserName)
            val userEmailTextView = headerView.findViewById<TextView>(R.id.user_email)

            clienteService.getClientes().enqueue(object : Callback<List<Cliente>> {
                override fun onResponse(call: Call<List<Cliente>>, response: Response<List<Cliente>>) {
                    if (response.isSuccessful) {
                        val clientes = response.body()
                        val usuario = clientes?.firstOrNull { it.usuario == username }

                        usuario?.let {
                            userNameTextView.text = it.usuario
                            userEmailTextView.text = it.correo
                        } ?: run {
                            Toast.makeText(
                                this@MainActivity,
                                "Usuario no encontrado en la base de datos",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            this@MainActivity,
                            "Error al cargar los datos del servidor",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<List<Cliente>>, t: Throwable) {
                    Toast.makeText(
                        this@MainActivity,
                        "Error de conexión al servidor",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}
