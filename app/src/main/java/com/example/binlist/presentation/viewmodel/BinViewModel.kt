package com.example.binlist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlist.core.common.ApiStatus
import com.example.binlist.designsystem.component.button.ButtonVariant
import com.example.binlist.domain.model.bank.BankInfo
import com.example.binlist.domain.model.bin.Bin
import com.example.binlist.domain.usecase.AddBankInfoLocalUseCase
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
    private val mapper: BankInfoStableMapper,
    private val addBankInfoLocalUseCase: AddBankInfoLocalUseCase
) : ViewModel() {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val bankInfo: StateFlow<BankInfoStable?> =
        getBankInfo.execute()
            .flatMapLatest { bankInfo ->
                flow {
                    when (bankInfo.status) {
                        ApiStatus.SUCCESS -> {
                            emit(value = bankInfo.data?.let {
                                mapper.bankInfoToBankInfoStable(
                                    it
                                )
                            })
                            bankInfo.data?.let {
                                addBankInfo(bankInfo = it)
                            }
                        }

                        ApiStatus.NO_DATA -> {
                            _errorMessage.tryEmit(value = bankInfo.message)
                        }

                        ApiStatus.BAD_REQUEST -> {
                            _errorMessage.tryEmit(value = bankInfo.message)
                        }

                        ApiStatus.LIMIT -> {
                            _errorMessage.tryEmit(value = bankInfo.message)
                        }

                        ApiStatus.ERROR -> {
                            _errorMessage.tryEmit(value = bankInfo.message)
                        }
                    }
                    updateButtonState(state = ButtonVariant.FILLED)
                }
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = null
            )

    private val _bin: MutableStateFlow<String?> = MutableStateFlow(null)
    private val bin: StateFlow<String?> = _bin

    private val _buttonState: MutableStateFlow<ButtonVariant> =
        MutableStateFlow(ButtonVariant.FILLED)
    private val buttonState: StateFlow<ButtonVariant> = _buttonState

    private val _errorMessage: MutableStateFlow<String?> = MutableStateFlow(null)
    private val errorMessage: StateFlow<String?> = _errorMessage

    fun getBankInfoFlow() = bankInfo
    fun getBinFlow() = bin
    fun getButtonStateFlow() = buttonState
    fun getErrorMessageFlow() = errorMessage

    fun loadBankInfo(bin: Bin) = viewModelScope.launch {
        updateButtonState(state = ButtonVariant.LOADING)
        loadBankInfo.execute(bin = bin) //TODO записывать последний запрос
    }

    private fun addBankInfo(bankInfo: BankInfo) = viewModelScope.launch {
        addBankInfoLocalUseCase.execute(bankInfo = bankInfo)
    }

    fun updateBin(bin: String) {
        _bin.update { bin }
    }

    private fun updateButtonState(state: ButtonVariant) {
        _buttonState.update { state }
    }
}