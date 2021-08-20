package com.example.phonestorage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CatalogDatabaseDao {
    @Insert
    suspend fun insertSmartPhone(smartPhone: SmartPhone)

    @Update
    suspend fun updateSmartPhone(smartPhone: SmartPhone)

    @Query("SELECT * FROM smartphones WHERE id = :id")
    fun getSmartPhone(id: Long): LiveData<SmartPhone>

    @Query("DELETE FROM smartphones WHERE id = :id")
    suspend fun deleteSmartPhone(id: Long)

    @Query("SELECT * FROM smartphones")
    fun getAllSmartPhones(): LiveData<List<SmartPhone>>
}