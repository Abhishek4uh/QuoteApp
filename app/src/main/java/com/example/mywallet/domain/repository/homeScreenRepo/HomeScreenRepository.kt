package com.example.mywallet.domain.repository.homeScreenRepo

import com.example.mywallet.common.Resource
import com.example.mywallet.domain.model.AllQuoteDC
import com.example.mywallet.domain.model.QuoteDC
import kotlinx.coroutines.flow.Flow

interface HomeScreenRepository {
    suspend fun getAllQuotes(): Flow<Resource<AllQuoteDC>>
    suspend fun getRandomQuote():Flow<Resource<QuoteDC>>
}