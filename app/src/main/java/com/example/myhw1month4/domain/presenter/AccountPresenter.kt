package com.example.myhw1month4.domain.presenter

import com.example.myhw1month4.data.model.Account
import com.example.myhw1month4.data.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AccountPresenter(val view: AccountContracts.View): AccountContracts.Presenter {

    override fun loadAccunts() {
        ApiClient.accountsApi.fetchAccounts().enqueue(object: Callback<List<Account>>{
            override fun onResponse(
                call: Call<List<Account>?>,
                response: Response<List<Account>?>
            ) {
                if (response.isSuccessful)
                    view.showAccounts(response.body() ?: emptyList())

            }

            override fun onFailure(
                call: Call<List<Account>?>,
                t: Throwable
            ) {

            }

        })
    }

    override fun createAccount(account: Account) {
        ApiClient.accountsApi.createAccounts(account)
            .enqueue(object : Callback<Account> {
                override fun onResponse(call: Call<Account>, response: Response<Account>) {
                    if (response.isSuccessful) {
                        loadAccunts()
                    }
                }

                override fun onFailure(call: Call<Account>, t: Throwable) {
                }
            })
    }


}