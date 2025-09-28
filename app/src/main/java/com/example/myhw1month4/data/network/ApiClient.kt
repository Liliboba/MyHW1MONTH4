package com.example.myhw1month4.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://68c81d115d8d9f514734573b.mockapi.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val accountsApi : AccountApi = retrofit.create(AccountApi::class.java)
}