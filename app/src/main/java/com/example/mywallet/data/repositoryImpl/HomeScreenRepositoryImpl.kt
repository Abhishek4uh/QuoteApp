package com.example.mywallet.data.repositoryImpl

import com.example.mywallet.common.Resource
import com.example.mywallet.common.extension.toErrorType
import com.example.mywallet.data.remote.RemoteRepository
import com.example.mywallet.domain.model.AllQuoteDC
import com.example.mywallet.domain.model.QuoteDC
import com.example.mywallet.domain.repository.homeScreenRepo.HomeScreenRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

class HomeScreenRepositoryImpl @Inject constructor(private val remoteRepository: RemoteRepository): HomeScreenRepository {
    override suspend fun getAllQuotes(): Flow<Resource<AllQuoteDC>> {
        return remoteRepository.getAllQuote().catch {
            emit(Resource.Error(it.toErrorType()))
        }
    }

    override suspend fun getRandomQuote(): Flow<Resource<QuoteDC>> {
        return  remoteRepository.getRandomQuote().catch {
            emit(Resource.Error(it.toErrorType()))
        }
    }


}