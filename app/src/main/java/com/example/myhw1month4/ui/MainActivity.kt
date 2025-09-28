package com.example.myhw1month4.ui

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myhw1month4.R
import com.example.myhw1month4.data.model.Account
import com.example.myhw1month4.databinding.ActivityMainBinding
import com.example.myhw1month4.domain.presenter.AccountContracts
import com.example.myhw1month4.domain.presenter.AccountPresenter
import com.example.myhw1month4.ui.adapter.AccountAdapter

class MainActivity : AppCompatActivity(), AccountContracts.View {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: AccountContracts.Presenter
    private lateinit var adapter: AccountAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = AccountPresenter(this)

        initAdapter()

        binding.btnAdd.setOnClickListener {
            showAddDialog()
        }
    }

    private fun initAdapter(){
        with(binding){
            adapter = AccountAdapter()
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter= adapter
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.loadAccunts()
    }

    override fun showAccounts(list: List<Account>) {
        adapter.submitList(list)
    }

    private fun showAddDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_add_account, null)

        val etName = dialogView.findViewById<EditText>(R.id.et_name)
        val etBalance = dialogView.findViewById<EditText>(R.id.et_balance)
        val etCurrency = dialogView.findViewById<EditText>(R.id.et_currency)

        AlertDialog.Builder(this)
            .setTitle("Добавить счёт")
            .setView(dialogView)
            .setPositiveButton("Сохранить") { _, _ ->
                val name = etName.text.toString()
                val balance = etBalance.text.toString().toIntOrNull() ?: 0
                val currency = etCurrency.text.toString()

                val account = Account(
                    name = name,
                    balance = balance,
                    currency = currency,
                    isActive = true
                )
                presenter.createAccount(account)
            }
            .setNegativeButton("Отмена", null)
            .show()
    }
}