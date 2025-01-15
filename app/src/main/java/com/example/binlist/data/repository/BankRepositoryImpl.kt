package com.example.binlist.data.repository

import com.example.binlist.core.common.ApiResult
import com.example.binlist.core.database.dao.BankInfoDao
import com.example.binlist.core.network.api.BinApi
import com.example.binlist.data.mapper.BankMapper
import com.example.binlist.domain.model.bank.BankDetails
import com.example.binlist.domain.model.bank.BankInfo
import com.example.binlist.domain.repository.BankRepository
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.retrofit.statusCode
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class BankRepositoryImpl(
    private val service: BinApi,
    private val mapper: BankMapper,
    private val dao: BankInfoDao
) : BankRepository {

    override fun getBankInfo(bin: String): Flow<ApiResult<BankInfo>> {
        return flow {
            val response = service.getBankInfo(bin = bin)

            response.suspendOnSuccess {
                emit(
                    value = ApiResult.Success(
                        mapper.bankInfoResponseToBankInfo(
                            bankInfo = data,
                            bin = bin
                        )
                    )
                )
            }.onFailure {
                ApiResult.Exception(exception = message())
            }
            response.suspendOnError {
                when (statusCode.code) {
                    BAD_REQUEST -> emit(value = ApiResult.BadRequest(error = "Bad request"))
                    NO_DATA -> emit(value = ApiResult.NoData(error = "No matches found"))
                    LIMIT -> emit(value = ApiResult.Limit(error = "Request limit exceeded"))
                }
            }
        }.flowOn(context = Dispatchers.IO)
    }

    override suspend fun addBankInfoLocal(bankInfo: BankDetails) = withContext(Dispatchers.IO) {
        dao.insertBankInfo(bankInfoEntity = mapper.bankInfoToBankInfoEntity(bankInfo))
    }

    override fun getBankInfoLocal(): Flow<List<BankDetails>> {
        return dao.getBankInfoList().flowOn(Dispatchers.IO).map {
            it.map { entity -> mapper.bankInfoEntityToBankInfo(bankInfo = entity) }
        }
    }

    private companion object {
        private const val BAD_REQUEST = 400
        private const val NO_DATA = 404
        private const val LIMIT = 429
    }
}