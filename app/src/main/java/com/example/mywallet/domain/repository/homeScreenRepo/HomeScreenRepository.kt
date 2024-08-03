package com.example.mywallet.domain.repository.homeScreenRepo

import com.example.mywallet.domain.model.AllQuoteDC
import com.example.mywallet.domain.model.QuoteDC
import retrofit2.Response

interface HomeScreenRepository {

    suspend fun getAllQuotes():Response<AllQuoteDC>
    suspend fun getRandomQuote():Response<QuoteDC>
}