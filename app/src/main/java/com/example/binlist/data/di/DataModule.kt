package com.example.binlist.data.di

import org.koin.dsl.module

val dataModule = module {
    includes(repositoryModule)
    includes(mapperModule)
}