package com.example.mywallet.common.extension

import com.example.mywallet.common.ErrorCodes
import com.example.mywallet.common.ErrorType
import retrofit2.HttpException
import java.io.IOException


fun Throwable.toErrorType() = when (this) {
    is IOException -> ErrorType.Api.Network
    is HttpException -> when (code()) {
        ErrorCodes.Http.ResourceNotFound -> ErrorType.Api.NotFound
        ErrorCodes.Http.InternalServer -> ErrorType.Api.Server
        ErrorCodes.Http.ServiceUnavailable -> ErrorType.Api.ServiceUnavailable
        else -> ErrorType.Unknown
    }
    else -> ErrorType.Unknown
}