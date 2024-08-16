package com.example.mywallet.presentation.commons.commonComponents



sealed class UiDataState<T> {
    class Loading<T>: UiDataState<T>()
    data class Error<T>(val error: ErrorText) : UiDataState<T>()
    data class Loaded<T>(val data: T): UiDataState<T>()
}