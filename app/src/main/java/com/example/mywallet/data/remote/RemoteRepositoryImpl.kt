package com.example.mywallet.data.remote

import com.example.mywallet.common.Resource
import com.example.mywallet.common.extension.toErrorType
import com.example.mywallet.domain.model.AllQuoteDC
import com.example.mywallet.domain.model.QuoteDC
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(private val api: ApiInterface):RemoteRepository{
    override fun getAllQuote(): Flow<Resource<AllQuoteDC>> = flow {
        try {
            val response = api.getAllQuote()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.toErrorType()))
        }
    }.flowOn(Dispatchers.IO)

    override fun getRandomQuote(): Flow<Resource<QuoteDC>> = flow {
        try {
            val response = api.getRandomQuote()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.toErrorType()))
        }
    }.flowOn(Dispatchers.IO)

    override fun getSingleQuote(id: String): Flow<Resource<QuoteDC>> = flow{
        try {
            val response = api.getSingleQuote(id)
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.toErrorType()))
        }
    }.flowOn(Dispatchers.IO)

}