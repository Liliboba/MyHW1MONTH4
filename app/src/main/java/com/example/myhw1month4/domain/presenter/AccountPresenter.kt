package com.example.myhw1month4.domain.presenter

import com.example.myhw1month4.data.model.Account
import com.example.myhw1month4.data.model.AccountState
import com.example.myhw1month4.data.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AccountPresenter(val view: AccountContracts.View): AccountContracts.Presenter {

    override fun loadAccounts() {
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
                        loadAccounts()
                    }
                }

                override fun onFailure(call: Call<Account>, t: Throwable) {
                }
            })
    }

    override fun updateFullyAccount(account: Account) {
        ApiClient.accountsApi.updateFullyAccount(account.id!!, account).enqueue(object : Callback<Unit>{
            override fun onResponse(
                call: Call<Unit?>,
                response: Response<Unit?>
            ) {
                if (response.isSuccessful) {
                    loadAccounts()
                }
            }

            override fun onFailure(call: Call<Unit?>, t: Throwable) {

            }

        })
    }

    override fun updateStateAccount(
        accountId: String,
        accountState: AccountState
    ) {
        ApiClient.accountsApi.updateStateAccount(accountId,accountState).enqueue(object : Callback<Unit>{
            override fun onResponse(
                call: Call<Unit?>,
                response: Response<Unit?>
            ) {
                if (response.isSuccessful) {
                    loadAccounts()
                }
            }

            override fun onFailure(call: Call<Unit?>, t: Throwable) {

            }

        })
    }

    override fun deleteAccount(accountId: String) {
        ApiClient.accountsApi.deleteAccount(accountId).enqueue(object : Callback<Unit>{
            override fun onResponse(
                call: Call<Unit?>,
                response: Response<Unit?>
            ) {
                if (response.isSuccessful) {
                    loadAccounts()
                }
            }

            override fun onFailure(call: Call<Unit?>, t: Throwable) {

            }

        })
    }

}

