package com.tecsup.loginapp.Services

import com.tecsup.loginapp.Models.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.GET


data class LoginRequest(val correo: String, val contrasena: String)

interface ClienteService {
    @POST("login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
    @GET("repertorios")
    fun getItems(): Call<List<Item>>
}
