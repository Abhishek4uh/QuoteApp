package com.example.mywallet.data.repositoryImpl

import com.example.mywallet.common.Resource
import com.example.mywallet.common.extension.toErrorType
import com.example.mywallet.data.remote.RemoteRepository
import com.example.mywallet.domain.model.QuoteDC
import com.example.mywallet.domain.repository.detailsScreenRepo.DetailScreenRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import javax.inject.Inject


class DetailScreenRepositoryImpl @Inject constructor(private val remoteRepository: RemoteRepository): DetailScreenRepository {
    override suspend fun getSingleQuote(id: String): Flow<Resource<QuoteDC>> {
        return remoteRepository.getSingleQuote(id).catch {
            emit(Resource.Error(it.toErrorType()))
        }
    }
}