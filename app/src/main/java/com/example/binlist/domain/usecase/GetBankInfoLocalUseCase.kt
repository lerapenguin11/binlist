package com.example.binlist.domain.usecase

import com.example.binlist.domain.model.bank.BankInfo
import com.example.binlist.domain.repository.BankRepository
import kotlinx.coroutines.flow.Flow

interface GetBankInfoLocalUseCase {
    fun execute(): Flow<List<BankInfo>>
}

class GetBankInfoLocalUseCaseImpl(private val repository: BankRepository) :
    GetBankInfoLocalUseCase {
    override fun execute(): Flow<List<BankInfo>> {
        return repository.getBankInfoLocal()
    }
}