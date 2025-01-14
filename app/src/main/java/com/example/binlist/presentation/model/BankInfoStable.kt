package com.example.binlist.presentation.model

import androidx.compose.runtime.Stable

@Stable
data class BankInfoStable(
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
    val prepaid: Boolean?
)
