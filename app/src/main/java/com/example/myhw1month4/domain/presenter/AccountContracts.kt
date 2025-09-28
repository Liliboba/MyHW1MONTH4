package com.example.myhw1month4.domain.presenter

import com.example.myhw1month4.data.model.Account
import com.example.myhw1month4.data.model.AccountState

interface AccountContracts {

    interface View {
        fun showAccounts(list: List<Account>)
    }

    interface Presenter {
        fun loadAccounts()
        fun createAccount(account: Account)
        fun updateFullyAccount(account: Account)
        fun updateStateAccount(accountId: String, accountState: AccountState)
        fun deleteAccount(accountId: String)
    }
}