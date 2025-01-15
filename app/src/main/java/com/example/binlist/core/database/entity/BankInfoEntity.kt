package com.example.binlist.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bank_info")
data class BankInfoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val scheme: String?,
    val type: String?,
    val length: Int?,
    val lunh: Boolean?,
    val country: String?,
    val latitude: Int?,
    val longitude: Int?,
    val phone: String?,
    val bankName: String?,
    val city: String?,
    val url: String?,
    val brand: String?,
    val prepaid: Boolean?,
    val bin: String
)