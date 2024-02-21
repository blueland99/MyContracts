package com.blueland99.mycontracts.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.blueland99.mycontracts.viewmodel.MainViewModel
import com.blueland99.mycontracts.R
import com.blueland99.mycontracts.databinding.ActivityMainBinding
import com.blueland99.mycontracts.view.adapter.ContractsAdapter

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private val adapter by lazy {
        ContractsAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        initView()
        initListener()
        subscribeObserver()
        initData()
    }

    private fun initView() = with(binding) {
        recyclerView.adapter = adapter
    }

    private fun initListener() = with(binding) {
        btnPlus.setOnClickListener {
            // TODO: 추가 버튼 클릭
        }
    }

    private fun subscribeObserver() {
        viewModel.contractList.observe(this) {
            adapter.contractList = it
        }
    }

    private fun initData() {
        viewModel.getContractList()
    }
}