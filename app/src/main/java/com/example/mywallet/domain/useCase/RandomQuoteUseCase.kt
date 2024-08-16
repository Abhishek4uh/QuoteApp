package com.example.mywallet.domain.useCase

import com.example.mywallet.domain.repository.homeScreenRepo.HomeScreenRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class RandomQuoteUseCase @Inject constructor(private val homeScreenRepository: HomeScreenRepository) {
     operator fun invoke()= flow{
         homeScreenRepository.getRandomQuote().collect{res->
             emit(res)
         }
    }.flowOn(Dispatchers.IO)
}