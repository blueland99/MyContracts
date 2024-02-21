package com.blueland99.mycontracts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var _contractList = MutableLiveData<List<String>>()
    val contractList: LiveData<List<String>>
        get() = _contractList

    fun getContractList() {
        // TODO: Get Contract List
        _contractList.value = arrayListOf("Jason", "Amy")
    }
}