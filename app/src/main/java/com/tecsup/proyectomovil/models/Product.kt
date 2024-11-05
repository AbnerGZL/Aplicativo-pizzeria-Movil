package com.tecsup.proyectomovil.models

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id") val id: Int,
    @SerializedName("nombre") val name: String,
    @SerializedName("precio") val price: String,
    @SerializedName("descripcion") val description: String,
    @SerializedName("imagen") val imageUrl: String
)
