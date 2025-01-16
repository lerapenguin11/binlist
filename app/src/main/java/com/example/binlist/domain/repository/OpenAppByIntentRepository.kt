package com.example.binlist.domain.repository

interface OpenAppByIntentRepository {

    fun openBrowserByUrl(url: String)
    fun openDialerByPhoneNumber(phoneNumber: String)
}