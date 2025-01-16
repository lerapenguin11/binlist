package com.example.binlist.domain.di

import com.example.binlist.domain.usecase.OpenDialerUseCase
import com.example.binlist.domain.usecase.OpenDialerUseCaseImpl
import com.example.binlist.domain.usecase.OpenUrlUseCase
import com.example.binlist.domain.usecase.OpenUrlUseCaseImpl
import com.example.binlist.domain.usecase.bank.AddBankInfoLocalUseCase
import com.example.binlist.domain.usecase.bank.AddBankInfoLocalUseCaseImpl
import com.example.binlist.domain.usecase.bank.GetBankInfo
import com.example.binlist.domain.usecase.bank.GetBankInfoLocalUseCase
import com.example.binlist.domain.usecase.bank.GetBankInfoLocalUseCaseImpl
import com.example.binlist.domain.usecase.bank.GetBankInfoUseCase
import com.example.binlist.domain.usecase.bank.InteractorLoadBankInfo
import org.koin.dsl.module

val domainModule = module {
    single { GetBankInfo() }
    single { GetBankInfoUseCase() }
    single { InteractorLoadBankInfo() }
    single<GetBankInfoLocalUseCase> { GetBankInfoLocalUseCaseImpl(repository = get()) }
    single<AddBankInfoLocalUseCase> { AddBankInfoLocalUseCaseImpl(repository = get()) }
    single<OpenUrlUseCase> { OpenUrlUseCaseImpl(repository = get()) }
    single<OpenDialerUseCase> { OpenDialerUseCaseImpl(repository = get()) }
}