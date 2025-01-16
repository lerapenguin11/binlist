package com.example.binlist.domain.usecase.bank

import com.example.binlist.domain.model.bank.BankInfo
import com.example.binlist.domain.repository.BankRepository

interface AddBankInfoLocalUseCase {
    suspend fun execute(bankInfo: BankInfo)
}

class AddBankInfoLocalUseCaseImpl(private val repository: BankRepository) :
    AddBankInfoLocalUseCase {
    override suspend fun execute(bankInfo: BankInfo) {
        repository.addBankInfoLocal(bankInfo = bankInfo)
    }
}