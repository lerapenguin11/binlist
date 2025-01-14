package com.example.binlist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlist.core.common.ApiResult
import com.example.binlist.core.common.ApiStatus
import com.example.binlist.domain.model.bank.BankInfo
import com.example.binlist.domain.model.bin.Bin
import com.example.binlist.domain.usecase.GetBankInfo
import com.example.binlist.domain.usecase.InteractorLoadBankInfo
import com.example.binlist.presentation.mapper.BankInfoStableMapper
import com.example.binlist.presentation.model.BankInfoStable
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BinViewModel(
    private val loadBankInfo: InteractorLoadBankInfo,
    private val getBankInfo: GetBankInfo,
    private val mapper: BankInfoStableMapper
) : ViewModel() {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val bankInfo: StateFlow<BankInfoStable?> =
        getBankInfo.execute()
            .flatMapLatest { bankInfo ->
                flow {
                    when (bankInfo.status) {
                        ApiStatus.SUCCESS -> emit(value = bankInfo.data?.let {
                            mapper.bankInfoToBankInfoStable(
                                it
                            )
                        })
                        else -> {}
                    }
                }
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = null
            )

    private val _bin: MutableStateFlow<String?> = MutableStateFlow(null)
    private val bin: StateFlow<String?> = _bin

    fun getBankInfoFlow() = bankInfo
    fun getBinFlow() = bin

    fun loadBankInfo(bin: Bin) = viewModelScope.launch {
        loadBankInfo.execute(bin = bin)
    }

    fun updateBin(bin: String) {
        _bin.update { bin }
    }
}