package com.tecsup.loginapp.Interface

import com.tecsup.loginapp.Models.Cliente
import retrofit2.Call
import retrofit2.http.*

interface ClienteService {
    @GET("clientes/")
    fun getClientes(): Call<List<Cliente>>

    @POST("clientes/")
    fun createCliente(@Body cliente: Cliente): Call<Cliente>

    @GET("clientes/{id}")
    fun getClientePorId(@Path("id") id: Int): Call<Cliente>

    @PUT("clientes/{id}")
    fun updateCliente(@Path("id") id: Int, @Body cliente: Cliente): Call<Cliente>

    @DELETE("clientes/{id}")
    fun deleteCliente(@Path("id") id: Int): Call<Void>
}
