package com.example.binlist.domain.repository

import com.example.binlist.core.common.ApiResult
import com.example.binlist.domain.model.bank.BankInfo
import kotlinx.coroutines.flow.Flow

interface BankRepository {

    fun getBankInfo(bin: String): Flow<ApiResult<BankInfo>>
}