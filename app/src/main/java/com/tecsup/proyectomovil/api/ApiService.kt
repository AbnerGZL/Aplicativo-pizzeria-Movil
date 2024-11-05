package com.tecsup.proyectomovil.api

import retrofit2.Call
import retrofit2.http.GET
import com.tecsup.proyectomovil.models.Product

interface ApiService {
    @GET("productos-venta/")
    fun getProducts(): Call<List<Product>>
}
