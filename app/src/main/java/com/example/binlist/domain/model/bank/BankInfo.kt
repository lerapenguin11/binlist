package com.example.binlist.domain.model.bank

data class BankInfo(
    val bank: Bank?,
    val brand: String?,
    val country: Country?,
    val number: Number?,
    val prepaid: Boolean?,
    val scheme: String?,
    val type: String?,
    val bin: String
)
