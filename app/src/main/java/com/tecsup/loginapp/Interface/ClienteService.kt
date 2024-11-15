package com.tecsup.loginapp.Interface

import com.tecsup.loginapp.Models.Cliente
import com.tecsup.loginapp.Models.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface ClienteService {

    @POST("login")
    fun login(@Body credentials: Map<String, String>): Call<LoginResponse>

    @POST("registro")
    fun createCliente(@Body cliente: Cliente): Call<Cliente>

    @GET("clientes")
    fun getClientes(): Call<List<Cliente>>
}