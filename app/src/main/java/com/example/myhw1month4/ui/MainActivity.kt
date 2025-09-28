package com.example.myhw1month4.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
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
}