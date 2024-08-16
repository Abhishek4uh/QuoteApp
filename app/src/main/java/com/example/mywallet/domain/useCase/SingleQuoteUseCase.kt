package com.example.mywallet.domain.useCase

import com.example.mywallet.domain.repository.detailsScreenRepo.DetailScreenRepository
import com.example.mywallet.domain.repository.homeScreenRepo.HomeScreenRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SingleQuoteUseCase @Inject constructor(private val detailScreenRepository: DetailScreenRepository) {

    operator fun invoke(id:String)= flow{
        detailScreenRepository.getSingleQuote(id).collect{res->
            emit(res)
        }
    }.flowOn(Dispatchers.IO)
}