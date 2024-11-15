package com.tecsup.loginapp.Models

data class Item(
    val name: String,
    val price: Double,
    val imageUrl: Int,
    var quantity: Int = 1
)