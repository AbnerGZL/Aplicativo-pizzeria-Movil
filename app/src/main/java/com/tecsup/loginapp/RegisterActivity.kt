package com.tecsup.loginapp

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tecsup.loginapp.Models.Cliente
import com.tecsup.loginapp.Retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var btnRegister: Button
    private lateinit var etUsername: EditText
    private lateinit var etEmail: EditText
    private lateinit var etTelefono: EditText
    private lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegister = findViewById(R.id.btnRegister)
        etUsername = findViewById(R.id.etUsername)
        etEmail = findViewById(R.id.etEmail)
        etTelefono = findViewById(R.id.etPhone)
        etPassword = findViewById(R.id.etPassword)

        btnRegister.setOnClickListener {
            val nombre = etUsername.text.toString()
            val correo = etEmail.text.toString()
            val telefono = etTelefono.text.toString()
            val contrasena = etPassword.text.toString()

            when {
                nombre.isEmpty() -> Toast.makeText(this, "Por favor ingrese un nombre de usuario", Toast.LENGTH_SHORT).show()
                !Patterns.EMAIL_ADDRESS.matcher(correo).matches() -> Toast.makeText(this, "Correo no válido", Toast.LENGTH_SHORT).show()
                telefono.length != 9 -> Toast.makeText(this, "Por favor ingrese un número de teléfono válido de 9 dígitos", Toast.LENGTH_SHORT).show()
                contrasena.isEmpty() -> Toast.makeText(this, "Por favor ingrese una contraseña", Toast.LENGTH_SHORT).show()
                contrasena.length < 8 -> Toast.makeText(this, "La contraseña debe tener al menos 8 caracteres", Toast.LENGTH_SHORT).show()
                else -> registrarUsuario(nombre, correo, telefono.toInt(), contrasena)
            }
        }
    }

    private fun registrarUsuario(nombreUsuario: String, correo: String, telefono: Int, contrasena: String) {
        val clienteService = RetrofitClient.instance
        val nuevoCliente = Cliente(usuario = nombreUsuario, correo = correo, telefono = telefono, contrasena = contrasena)

        clienteService.createCliente(nuevoCliente).enqueue(object : Callback<Cliente> {
            override fun onResponse(call: Call<Cliente>, response: Response<Cliente>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@RegisterActivity, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    val errorBody = response.errorBody()?.string()
                    if (errorBody != null) {
                        when {
                            errorBody.contains("correo") -> {
                                Toast.makeText(this@RegisterActivity, "El correo ya está registrado.", Toast.LENGTH_LONG).show()
                            }
                            errorBody.contains("usuario") -> {
                                Toast.makeText(this@RegisterActivity, "El nombre de usuario ya está registrado.", Toast.LENGTH_LONG).show()
                            }
                            else -> {
                                Toast.makeText(this@RegisterActivity, "Error al registrar usuario: ${response.code()}", Toast.LENGTH_LONG).show()
                            }
                        }
                    } else {
                        Toast.makeText(this@RegisterActivity, "Error al registrar usuario: ${response.code()}", Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onFailure(call: Call<Cliente>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Error de conexión", Toast.LENGTH_SHORT).show()
            }
        })
    }
}