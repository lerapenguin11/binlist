package com.example.binlist.data.di

import com.example.binlist.data.repository.BankRepositoryImpl
import com.example.binlist.data.repository.OpenAppByIntentRepositoryImpl
import com.example.binlist.domain.repository.BankRepository
import com.example.binlist.domain.repository.OpenAppByIntentRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single<BankRepository> { BankRepositoryImpl(service = get(), mapper = get(), dao = get()) }
    single<OpenAppByIntentRepository> { OpenAppByIntentRepositoryImpl(context = androidContext().applicationContext) }
}