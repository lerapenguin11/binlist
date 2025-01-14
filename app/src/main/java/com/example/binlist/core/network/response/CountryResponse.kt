package com.example.binlist.core.network.response

data class CountryResponse(
    val alpha2: String,
    val currency: String,
    val emoji: String,
    val latitude: Int,
    val longitude: Int,
    val name: String,
    val numeric: String
)