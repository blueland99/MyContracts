package com.blueland99.mycontracts.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blueland99.mycontracts.databinding.ItemContractBinding

class ContractsAdapter : RecyclerView.Adapter<ContractsAdapter.ViewHolder>() {

    var contractList: List<String>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(private val binding: ItemContractBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(number: String) {
            binding.tvNumber.text = number
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemContractBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        contractList?.let {
            holder.bindView(it[position])
        }
    }

    override fun getItemCount(): Int {
        return contractList?.size ?: 0
    }
}