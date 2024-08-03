package com.example.mywallet.data.repositoryImpl

import com.example.mywallet.data.remote.ApiInterface
import com.example.mywallet.domain.model.AllQuoteDC
import com.example.mywallet.domain.model.QuoteDC
import com.example.mywallet.domain.repository.homeScreenRepo.HomeScreenRepository
import retrofit2.Response
import javax.inject.Inject

class HomeScreenRepositoryImpl @Inject constructor(private val apiInterface: ApiInterface): HomeScreenRepository {

    override suspend fun getAllQuotes(): Response<AllQuoteDC> {
        return apiInterface.getAllQuote()
    }

    override suspend fun getRandomQuote(): Response<QuoteDC> {
        return apiInterface.getRandomQuote()
    }

}