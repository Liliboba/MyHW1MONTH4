package com.example.myhw1month4.domain.presenter

import com.example.myhw1month4.data.model.Account

class AccountPresenter(val view: AccountContracts.View): AccountContracts.Presenter {

    override fun loadAccunts() {
        val testMockAccount = listOf(
            Account(
                id = "1",
                name = "M bank ",
                currency = "USD",
                balance = 1000
            ),
            Account(
                id = "2",
                name = "Alpha Bank",
                currency = "KGS",
                balance = 50000
            ),

            Account(
                id = "3",
                name = "Unity Bank",
                currency = "EUR",
                balance = 200
            ),
        )
        view.showAccounts(testMockAccount)
    }

}