package com.example.binlist.data.di

import com.example.binlist.data.mapper.BankMapper
import org.koin.dsl.module

val mapperModule = module {
    single { BankMapper() }
}