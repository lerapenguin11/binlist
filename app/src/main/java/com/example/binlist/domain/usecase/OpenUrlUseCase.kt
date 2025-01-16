package com.example.binlist.domain.usecase

import com.example.binlist.domain.repository.OpenAppByIntentRepository

interface OpenUrlUseCase {
    fun execute(url: String)
}

class OpenUrlUseCaseImpl(private val repository: OpenAppByIntentRepository) : OpenUrlUseCase {
    override fun execute(url: String) {
        repository.openBrowserByUrl(url = url)
    }
}