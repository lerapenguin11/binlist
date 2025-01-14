package com.example.binlist.core.network.di

import com.example.binlist.core.network.api.BinApi
import org.koin.dsl.module

val serviceModule = module {
    val networkModule by lazy {
        NetworkModule()
    }
    single { networkModule.getRetrofit().create(BinApi::class.java) }
}