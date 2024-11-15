package com.tecsup.loginapp.Interface

import com.tecsup.loginapp.Models.*
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.POST
import com.tecsup.loginapp.Models.LoginResponse

interface ClienteService {
    @POST("login")
    fun login(@Body credentials: Map<String, String>): Call<LoginResponse>

    @POST("registro")
    fun createCliente(@Body cliente: Cliente): Call<Cliente>

    @GET("repertorios")
    suspend fun getItems(): List<Item>

    @GET("clientes")
    fun getClientes(): Call<List<Cliente>>

    @DELETE("clientes")
    fun deleteCliente(@Path("id") id: Int): Call<Void>

    @GET("repertorios")
    fun getProducts(): Call<List<Product>>
}
