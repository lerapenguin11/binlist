package com.example.binlist.domain.model.bank

data class BankDetails(
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
