package com.example.phonestorage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CatalogViewModel(
    dataSource: CatalogDatabaseDao
): ViewModel() {
    private val catalogDatabase = dataSource

    val smartPhones = catalogDatabase.getAllSmartPhones()

    fun insertSmartPhone(smartPhone: SmartPhone) {
        viewModelScope.launch {
            catalogDatabase.insertSmartPhone(smartPhone)
        }
    }

    fun deleteSmartPhone(id: Long) {
        viewModelScope.launch {
            catalogDatabase.deleteSmartPhone(id)
        }
    }
}