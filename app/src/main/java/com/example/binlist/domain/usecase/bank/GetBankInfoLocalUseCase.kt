package com.example.binlist.domain.usecase.bank

import com.example.binlist.domain.model.bank.BankDetails
import com.example.binlist.domain.repository.BankRepository
import kotlinx.coroutines.flow.Flow

interface GetBankInfoLocalUseCase {
    fun execute(): Flow<List<BankDetails>>
}

class GetBankInfoLocalUseCaseImpl(private val repository: BankRepository) :
    GetBankInfoLocalUseCase {
    override fun execute(): Flow<List<BankDetails>> {
        return repository.getBankInfoLocal()
    }
}