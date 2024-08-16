package com.example.mywallet.domain.repository.detailsScreenRepo

import com.example.mywallet.common.Resource
import com.example.mywallet.domain.model.QuoteDC
import kotlinx.coroutines.flow.Flow

interface DetailScreenRepository {
    suspend fun getSingleQuote(id:String): Flow<Resource<QuoteDC>>
}