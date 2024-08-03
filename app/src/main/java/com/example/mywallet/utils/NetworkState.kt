package com.example.mywallet.utils

sealed class NetworkState<T>{
    class LOADING<T>:NetworkState<T>()
    data class SUCCESS<T> (val data:T):NetworkState<T>()
    data class ERROR<T>(val error:Any):NetworkState<T>()
}
