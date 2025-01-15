package com.example.binlist.domain.usecase

import com.example.binlist.domain.model.bank.BankDetails
import com.example.binlist.domain.repository.BankRepository

interface AddBankInfoLocalUseCase {
    suspend fun execute(bankInfo: BankDetails)
}

class AddBankInfoLocalUseCaseImpl(private val repository: BankRepository) :
    AddBankInfoLocalUseCase {
    override suspend fun execute(bankInfo: BankDetails) {
        repository.addBankInfoLocal(bankInfo = bankInfo)
    }
}