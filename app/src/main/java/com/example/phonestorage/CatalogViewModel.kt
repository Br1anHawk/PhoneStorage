package com.example.phonestorage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CatalogViewModel(
    dataSource: CatalogDatabaseDao
): ViewModel() {
    private val catalogDatabase = dataSource

    val smartPhones = catalogDatabase.getAllSmartPhones()

    private val smartPhone =  MutableLiveData<SmartPhone?>()

    fun insertSmartPhone(smartPhone: SmartPhone) {
        viewModelScope.launch {
            catalogDatabase.insertSmartPhone(smartPhone)
        }
    }

    fun updateSmartPhone(smartPhone: SmartPhone) {
        viewModelScope.launch {
            catalogDatabase.updateSmartPhone(smartPhone)
        }
    }

    fun getSmartPhone(id: Long): SmartPhone? {
        return smartPhone.value
    }

    fun deleteSmartPhone(id: Long) {
        viewModelScope.launch {
            catalogDatabase.deleteSmartPhone(id)
        }
    }
}