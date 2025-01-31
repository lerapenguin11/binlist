package com.example.binlist.domain.usecase.bank

import com.example.binlist.domain.model.bin.Bin
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetBankInfoUseCase {
    private val streamBankInfoFromBinParam: MutableSharedFlow<Bin?> = MutableStateFlow(null)

    fun loadBankInfo(
        bin: Bin
    ) {
        streamBankInfoFromBinParam.tryEmit(value = bin)
    }

    fun trigger(): SharedFlow<Bin?> =
        streamBankInfoFromBinParam
}

class InteractorLoadBankInfo : KoinComponent {
    private val innerInfo: GetBankInfoUseCase by inject()

    fun execute(
        bin: Bin
    ) {
        innerInfo.loadBankInfo(
            bin = bin
        )
    }
}