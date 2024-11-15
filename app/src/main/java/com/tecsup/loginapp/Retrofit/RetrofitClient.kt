package com.tecsup.loginapp.Retrofit

import com.tecsup.loginapp.Interface.ClienteService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://elote.pythonanywhere.com/api/"
    private const val TOKEN = "c6cf9d5275f5c1209ed66231d04e0a5cc17d8560"

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain: Interceptor.Chain ->
            val request: Request = chain.request().newBuilder()
                .addHeader("Authorization", "Token $TOKEN")
                .build()
            chain.proceed(request)
        }
        .build()

    val instance: ClienteService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ClienteService::class.java)
    }
}