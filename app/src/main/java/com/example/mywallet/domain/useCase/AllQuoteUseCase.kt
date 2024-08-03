package com.example.mywallet.domain.useCase


import com.example.mywallet.domain.repository.homeScreenRepo.HomeScreenRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class AllQuoteUseCase @Inject constructor(private val homeScreenRepository: HomeScreenRepository) {
     operator fun invoke()= flow{
         homeScreenRepository.getAllQuotes().let {res->
            if (res.isSuccessful){
                emit( res.body()?.quote)
            }
        }
    }
}