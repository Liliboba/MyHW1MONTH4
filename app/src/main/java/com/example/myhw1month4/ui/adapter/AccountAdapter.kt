package com.example.myhw1month4.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import com.example.myhw1month4.data.model.Account
import com.example.myhw1month4.databinding.ItemAccountBinding

class AccountAdapter(
    val onEdit: (Account) -> Unit,
    val onDelete: (String) -> Unit,
    val onSwitchToggleButton: (String, Boolean) -> Unit
): RecyclerView.Adapter<AccountAdapter.AccountViewHolder>() {

    private val items = mutableListOf<Account>()

    fun submitList(data: List<Account>){
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val binding = ItemAccountBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AccountViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        holder.bind(items[position])
    }


    inner class AccountViewHolder(private val binding: ItemAccountBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(account: Account) = with(binding) {
            tvName.text = account.name
            tvBalance.text = "${account.balance} ${account.currency}"
            btnEdit.setOnClickListener {
                onEdit(account)
            }
            btnDelete.setOnClickListener {
                account.id?.let {
                    onDelete(it)
                }

            }
            switcher.isChecked = account.isActive == true
            switcher.setOnCheckedChangeListener { buttonView, isChecked ->
                account.id?.let {
                    onSwitchToggleButton(it, isChecked)
                }
            }
        }
    }
}