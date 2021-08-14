package com.example.phonestorage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.sql.CommonDataSource

class ViewModelsFactory(
    private val dataSource: CatalogDatabaseDao
): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CatalogViewModel::class.java)) {
            return CatalogViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}