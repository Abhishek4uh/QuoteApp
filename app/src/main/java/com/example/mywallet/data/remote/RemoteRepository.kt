package com.example.mywallet.data.remote

import com.example.mywallet.common.Resource
import com.example.mywallet.domain.model.AllQuoteDC
import com.example.mywallet.domain.model.QuoteDC
import kotlinx.coroutines.flow.Flow

interface RemoteRepository {
    fun getAllQuote(): Flow<Resource<AllQuoteDC>>

    fun getRandomQuote(): Flow<Resource<QuoteDC>>

    fun getSingleQuote(id:String):Flow<Resource<QuoteDC>>
}