package com.example.binlist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlist.domain.usecase.OpenDialerUseCase
import com.example.binlist.domain.usecase.OpenUrlUseCase
import com.example.binlist.domain.usecase.bank.GetBankInfoLocalUseCase
import com.example.binlist.presentation.mapper.BankInfoStableMapper
import com.example.binlist.presentation.model.BankInfoStable
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class BinListViewModel(
    private val getBankInfoLocalUseCase: GetBankInfoLocalUseCase,
    private val mapper: BankInfoStableMapper,
    private val openUrlUseCase: OpenUrlUseCase,
    private val openDialerUseCase: OpenDialerUseCase
) : ViewModel() {
    @OptIn(ExperimentalCoroutinesApi::class)
    private val bankInfo: StateFlow<List<BankInfoStable>> =
        getBankInfoLocalUseCase.execute().flatMapLatest { bankDetails ->
            flow {
                emit(value = bankDetails.map {
                    mapper.bankDetailsToBankInfoStable(it)

                })
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    fun getBankInfoFlow() = bankInfo

    fun openUrl(url: String) {
        openUrlUseCase.execute(url = url)
    }

    fun openDialer(phoneNumber: String) = viewModelScope.launch {
        openDialerUseCase.execute(phoneNumber = phoneNumber)
    }
}