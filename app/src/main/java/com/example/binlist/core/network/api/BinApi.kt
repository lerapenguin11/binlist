package com.example.binlist.core.network.api

import com.example.binlist.core.network.response.BankInfoResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BinApi {

    @GET("{bin}")
    suspend fun getBankInfo(@Path("bin") bin: String): ApiResponse<BankInfoResponse>
}