package com.example.binlist.core.database.di

import com.example.binlist.core.database.db.BankInfoDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        BankInfoDatabase.getInstance(context = get())
    }
    single { get<BankInfoDatabase>().getBankInfoDao() }
}