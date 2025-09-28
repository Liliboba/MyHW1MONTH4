package com.example.myhw1month4.domain.presenter

import com.example.myhw1month4.data.model.Account

interface AccountContracts {

    interface View {
        fun showAccounts(list: List<Account>)
    }

    interface Presenter {
        fun loadAccunts()
        fun createAccount(account: Account)
    }
}