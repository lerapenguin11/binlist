package com.example.binlist.presentation.di

import com.example.binlist.presentation.viewmodel.BinListViewModel
import com.example.binlist.presentation.viewmodel.BinViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::BinViewModel)
    viewModelOf(::BinListViewModel)
    includes(mapperModule)
}