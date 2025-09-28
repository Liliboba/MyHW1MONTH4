package com.example.myhw1month4.data.network


import com.example.myhw1month4.data.model.Account
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AccountApi {

    @GET("AccountApi")
    fun fetchAccounts(): Call<List<Account>>

    @POST("AccountApi")
    fun createAccounts(@Body account: Account): Call<Account>

}