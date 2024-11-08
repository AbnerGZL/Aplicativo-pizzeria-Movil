package com.tecsup.loginapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.widget.Toast
import com.tecsup.loginapp.Models.Cliente
import com.tecsup.loginapp.Retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AccountFragment : Fragment() {

    private lateinit var tvUsername: TextView
    private lateinit var tvName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvPhone: TextView
    private lateinit var tvPassword: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var profileContent: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_account, container, false)

        tvUsername = view.findViewById(R.id.tvUsername)
        tvName = view.findViewById(R.id.tvName)
        tvEmail = view.findViewById(R.id.tvEmail)
        tvPhone = view.findViewById(R.id.tvPhone)
        tvPassword = view.findViewById(R.id.tvPassword)
        progressBar = view.findViewById(R.id.progressBar)
        profileContent = view.findViewById(R.id.profileContent)

        cargarDatosUsuario()

        return view
    }

    private fun cargarDatosUsuario() {
        val clienteService = RetrofitClient.instance
        progressBar.visibility = View.VISIBLE
        profileContent.visibility = View.GONE

        clienteService.getClientes().enqueue(object : Callback<List<Cliente>> {
            override fun onResponse(call: Call<List<Cliente>>, response: Response<List<Cliente>>) {
                if (response.isSuccessful) {
                    val clientes = response.body()
                    val usuario = clientes?.firstOrNull()
                    usuario?.let {
                        tvUsername.text = it.usuario
                        tvName.text = it.usuario
                        tvEmail.text = it.correo
                        tvPhone.text = it.telefono.toString()
                        tvPassword.text = "********"
                    }

                    // Ocultar el ProgressBar y mostrar los datos de usuario
                    progressBar.visibility = View.GONE
                    profileContent.visibility = View.VISIBLE
                } else {
                    Toast.makeText(context, "Error al cargar los datos", Toast.LENGTH_SHORT).show()
                    progressBar.visibility = View.GONE
                }
            }

            override fun onFailure(call: Call<List<Cliente>>, t: Throwable) {
                Toast.makeText(context, "Error de conexión", Toast.LENGTH_SHORT).show()
                progressBar.visibility = View.GONE
            }
        })
    }

    private fun setVisibilityForUserFields(visibility: Int) {
        tvUsername.visibility = visibility
        tvName.visibility = visibility
        tvEmail.visibility = visibility
        tvPhone.visibility = visibility
        tvPassword.visibility = visibility
    }
}
