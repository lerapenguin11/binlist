package com.example.binlist.core.common

enum class ApiStatus {
    SUCCESS,
    ERROR,
    BAD_REQUEST,
    NO_DATA,
    LOADING
}

sealed class ApiResult<out T>(val status: ApiStatus, val data: T?, val message: String?) {

    data class Success<out R>(val _data: R?) : ApiResult<R>(
        status = ApiStatus.SUCCESS,
        data = _data,
        message = null
    )

    data class Exception(val exception: String) : ApiResult<Nothing>(
        status = ApiStatus.ERROR,
        data = null,
        message = exception
    )

    data class BadRequest(val error: String?) : ApiResult<Nothing>(
        status = ApiStatus.BAD_REQUEST,
        data = null,
        message = error
    )

    data class NoData(val error: String?): ApiResult<Nothing>(
        status = ApiStatus.NO_DATA,
        data = null,
        message = error
    )

    data class Loading<out R>(val _data: R?, val isLoading: Boolean) : ApiResult<R>(
        status = ApiStatus.LOADING,
        data = _data,
        message = null
    )
}