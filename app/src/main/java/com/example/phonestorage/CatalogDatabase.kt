package com.example.phonestorage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SmartPhone::class], version = 2, exportSchema = false)
abstract class CatalogDatabase: RoomDatabase() {
    abstract val catalogDatabaseDao: CatalogDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: CatalogDatabase? = null
        fun getInstance(context: Context): CatalogDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(
                            context.applicationContext,
                            CatalogDatabase::class.java,
                            "catalog"
                        )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}