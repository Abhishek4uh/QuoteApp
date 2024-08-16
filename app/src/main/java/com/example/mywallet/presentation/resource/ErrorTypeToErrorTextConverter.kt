package com.example.mywallet.presentation.resource

import com.example.mywallet.R
import com.example.mywallet.common.ErrorType
import com.example.mywallet.presentation.commons.commonComponents.ErrorText


interface ErrorTypeToErrorTextConverter {

    fun convert(errorType: ErrorType): ErrorText
}

class ErrorTypeToErrorTextConverterImpl : ErrorTypeToErrorTextConverter {

    override fun convert(errorType: ErrorType) = when (errorType) {
        ErrorType.Api.NotFound -> ErrorText.StringResource(R.string.error_resource_not_found)
        ErrorType.Api.ServiceUnavailable -> ErrorText.StringResource(R.string.error_service_unavailable)
        ErrorType.Api.Server -> ErrorText.StringResource(R.string.error_server)
        ErrorType.Api.Network -> ErrorText.StringResource(R.string.error_network_unavailable)
        ErrorType.Unknown -> ErrorText.StringResource(R.string.error_general)
    }
}