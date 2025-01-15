package com.example.binlist.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.binlist.core.database.entity.BankInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BankInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBankInfo(bankInfoEntity: BankInfoEntity)

    @Query("SELECT * FROM bank_info")
    fun getBankInfoList(): Flow<List<BankInfoEntity>>
}