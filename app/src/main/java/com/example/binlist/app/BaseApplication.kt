package com.example.binlist.app

import android.app.Application
import com.example.binlist.core.network.di.serviceModule
import com.example.binlist.di.appModule
import com.example.binlist.di.dataModule
import com.example.binlist.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@BaseApplication)
            modules(
                listOf(
                    appModule,
                    dataModule,
                    domainModule,
                    serviceModule
                )
            )
        }
    }
}