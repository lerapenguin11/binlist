package com.example.binlist.core.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.binlist.core.database.dao.BankInfoDao
import com.example.binlist.core.database.entity.BankInfoEntity
import com.example.binlist.utils.CommonString

@Database(entities = [BankInfoEntity::class], version = 1, exportSchema = false)
abstract class BankInfoDatabase : RoomDatabase() {

    abstract fun getBankInfoDao(): BankInfoDao

    companion object {
        private var instance: BankInfoDatabase? = null

        fun getInstance(context: Context): BankInfoDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): BankInfoDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                BankInfoDatabase::class.java,
                context.getString(CommonString.database_name)
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}