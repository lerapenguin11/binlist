package com.example.binlist.domain.usecase

import com.example.binlist.domain.repository.OpenAppByIntentRepository

interface OpenDialerUseCase {
    fun execute(phoneNumber: String)
}

class OpenDialerUseCaseImpl(private val repository: OpenAppByIntentRepository) : OpenDialerUseCase {
    override fun execute(phoneNumber: String) {
        repository.openDialerByPhoneNumber(phoneNumber = phoneNumber)
    }
}