package com.example.myhw1month4.data.network


import com.example.myhw1month4.data.model.Account
import com.example.myhw1month4.data.model.AccountState
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface AccountApi {

    @GET("AccountApi")
    fun fetchAccounts(): Call<List<Account>>

    @POST("AccountApi")
    fun createAccounts(@Body account: Account): Call<Account>

    @PUT("AccountApi/{id}")
    fun updateFullyAccount(
        @Path("id") accountId: String,
        @Body account: Account
    ): Call<Unit>

    @PATCH("AccountApi/{id}")
    fun updateStateAccount(
        @Path("id") accountId: String,
        @Body accountState: AccountState
    ): Call<Unit>

    @DELETE("AccountApi/{id}")
    fun deleteAccount(
        @Path("id") id: String
    ): Call<Unit>

}