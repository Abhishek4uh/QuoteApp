package com.example.mywallet.data.remote

import com.example.mywallet.domain.model.AllQuoteDC
import com.example.mywallet.domain.model.QuoteDC
import com.example.mywallet.common.AppConstants.ALL_QUOTES
import com.example.mywallet.common.AppConstants.RANDOM
import com.example.mywallet.common.AppConstants.SINGLE_QUOTE
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiInterface {

    @GET(ALL_QUOTES)
    suspend fun getAllQuote():AllQuoteDC

    @GET(RANDOM)
    suspend fun getRandomQuote():QuoteDC

    @GET(SINGLE_QUOTE)
    suspend fun getSingleQuote(@Path("id")id:String):QuoteDC
}