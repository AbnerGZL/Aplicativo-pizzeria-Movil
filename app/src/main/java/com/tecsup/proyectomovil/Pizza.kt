package com.tecsup.proyectomovil

data class Pizza(
    val nombre: String,
    val precio: Int,
    var cantidad: Int,
    val imagenResId: Int
) {
    fun precioTotal(): Int {
        return precio * cantidad
    }
}

