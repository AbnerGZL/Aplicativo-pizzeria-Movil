package com.tecsup.loginapp.Models

data class Cliente(
    val id_cliente: Int? = null,
    val usuario: String,
    val correo: String,
    val telefono: Int,
    val contrasena: String
)
