package com.example.binlist.domain.di

import com.example.binlist.domain.usecase.GetBankInfo
import com.example.binlist.domain.usecase.GetBankInfoUseCase
import com.example.binlist.domain.usecase.InteractorLoadBankInfo
import org.koin.dsl.module

val domainModule = module {
    single { GetBankInfo() }
    single { GetBankInfoUseCase() }
    single { InteractorLoadBankInfo() }
}