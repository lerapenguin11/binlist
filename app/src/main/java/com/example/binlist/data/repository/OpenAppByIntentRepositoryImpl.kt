package com.example.binlist.data.repository

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.example.binlist.domain.repository.OpenAppByIntentRepository

class OpenAppByIntentRepositoryImpl(private val context: Context): OpenAppByIntentRepository {

    private val openUrl = Intent(Intent.ACTION_VIEW)
    private val openDialer = Intent(Intent.ACTION_DIAL)

    override fun openBrowserByUrl(url: String) {
        openUrl.data = Uri.parse(url)
        openUrl.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(openUrl)
    }

    override fun openDialerByPhoneNumber(phoneNumber: String) {
        openDialer.data = Uri.parse("tel:$phoneNumber")
        openDialer.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(openDialer)
    }
}