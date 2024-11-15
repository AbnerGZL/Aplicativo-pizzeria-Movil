package com.tecsup.loginapp.Models

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val description: String,
    val imageUrl: String // Esto debe ser de tipo String
)
