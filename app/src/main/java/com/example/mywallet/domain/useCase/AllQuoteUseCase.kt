package com.example.mywallet.domain.useCase


import com.example.mywallet.domain.repository.homeScreenRepo.HomeScreenRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class AllQuoteUseCase @Inject constructor(private val homeScreenRepository: HomeScreenRepository) {
     operator fun invoke() = flow{
        homeScreenRepository.getAllQuotes().collect{result->
            emit(result)
        }
    }.flowOn(Dispatchers.IO)
}