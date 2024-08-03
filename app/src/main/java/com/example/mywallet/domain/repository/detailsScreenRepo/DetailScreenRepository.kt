package com.example.mywallet.domain.repository.detailsScreenRepo

import com.example.mywallet.domain.model.QuoteDC
import retrofit2.Response

interface DetailScreenRepository {
    suspend fun getSingleQuote(id:String): Response<QuoteDC>
}