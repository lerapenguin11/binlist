package com.example.binlist.data.di

import com.example.binlist.data.repository.BankRepositoryImpl
import com.example.binlist.domain.repository.BankRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<BankRepository> { BankRepositoryImpl(service = get(), get()) }
}