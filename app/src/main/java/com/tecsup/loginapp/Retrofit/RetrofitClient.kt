package com.tecsup.loginapp.Retrofit

import com.tecsup.loginapp.Interface.ClienteService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://elote.pythonanywhere.com/api/"

    val instance: ClienteService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ClienteService::class.java)
    }
}
