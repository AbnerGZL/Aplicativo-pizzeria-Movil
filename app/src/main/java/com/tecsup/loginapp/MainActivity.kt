package com.tecsup.loginapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
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
        val toolbar: Toolbar = findViewById(R.id.toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )

        toggle.drawerArrowDrawable.setColor(ContextCompat.getColor(this, R.color.white))

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.Inicio -> loadFragment(HomeFragment())
                R.id.Compras -> {
                    val intent = Intent(this, HistorialActivity::class.java)
                    startActivity(intent)
                }
                R.id.Pedidos -> {
                    val intent = Intent(this, HistorialActivity::class.java)
                    startActivity(intent)
                }
                R.id.Cuenta -> loadFragment(AccountFragment())
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> loadFragment(HomeFragment())
                R.id.nav_cart -> loadFragment(CartFragment())
                R.id.nav_account -> loadFragment(AccountFragment())
            }
            true
        }

        cargarDatosUsuario()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
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

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commitAllowingStateLoss()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
