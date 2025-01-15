package com.example.binlist.domain.di

import com.example.binlist.domain.usecase.AddBankInfoLocalUseCase
import com.example.binlist.domain.usecase.AddBankInfoLocalUseCaseImpl
import com.example.binlist.domain.usecase.GetBankInfo
import com.example.binlist.domain.usecase.GetBankInfoLocalUseCase
import com.example.binlist.domain.usecase.GetBankInfoLocalUseCaseImpl
import com.example.binlist.domain.usecase.GetBankInfoUseCase
import com.example.binlist.domain.usecase.InteractorLoadBankInfo
import org.koin.dsl.module

val domainModule = module {
    single { GetBankInfo() }
    single { GetBankInfoUseCase() }
    single { InteractorLoadBankInfo() }
    single<GetBankInfoLocalUseCase> { GetBankInfoLocalUseCaseImpl(repository = get()) }
    single<AddBankInfoLocalUseCase> { AddBankInfoLocalUseCaseImpl(repository = get()) }
}