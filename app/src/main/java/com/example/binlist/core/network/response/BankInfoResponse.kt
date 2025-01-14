package com.example.binlist.core.network.response

data class BankInfoResponse(
    val bank: BankResponse?,
    val brand: String?,
    val country: CountryResponse?,
    val number: NumberResponse?,
    val prepaid: Boolean?,
    val scheme: String?,
    val type: String?
)