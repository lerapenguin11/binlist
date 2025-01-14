package com.example.binlist.domain.usecase

import com.example.binlist.core.common.ApiResult
import com.example.binlist.domain.model.bank.BankInfo
import com.example.binlist.domain.repository.BankRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.mapLatest
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetBankInfo : KoinComponent {
    private val repository: BankRepository by inject()
    private val useCase: GetBankInfoUseCase by inject()

    @OptIn(ExperimentalCoroutinesApi::class)
    private val bankInfoPrepared: Flow<ApiResult<BankInfo>> =
        useCase.trigger().filterNotNull().mapLatest { bin ->
            repository.getBankInfo(
                bin = bin.bin
            )
        }.flatMapMerge { it }

    fun execute(): Flow<ApiResult<BankInfo>> = bankInfoPrepared
}