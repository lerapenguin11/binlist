package com.example.binlist.presentation.di

import com.example.binlist.presentation.mapper.BankInfoStableMapper
import org.koin.dsl.module

val mapperModule = module {
    single { BankInfoStableMapper() }
}