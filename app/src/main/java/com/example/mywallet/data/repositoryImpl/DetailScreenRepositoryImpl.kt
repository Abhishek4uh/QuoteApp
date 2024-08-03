package com.example.mywallet.data.repositoryImpl

import com.example.mywallet.data.remote.ApiInterface
import com.example.mywallet.domain.model.QuoteDC
import com.example.mywallet.domain.repository.detailsScreenRepo.DetailScreenRepository
import retrofit2.Response
import javax.inject.Inject


class DetailScreenRepositoryImpl @Inject constructor(private val apiInterface: ApiInterface): DetailScreenRepository {
    override suspend fun getSingleQuote(id: String): Response<QuoteDC> {
        return  apiInterface.getSingleQuote(id=id)
    }
}