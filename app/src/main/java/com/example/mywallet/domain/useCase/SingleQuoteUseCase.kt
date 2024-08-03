package com.example.mywallet.domain.useCase

import com.example.mywallet.domain.repository.detailsScreenRepo.DetailScreenRepository
import com.example.mywallet.domain.repository.homeScreenRepo.HomeScreenRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SingleQuoteUseCase @Inject constructor(private val detailScreenRepository: DetailScreenRepository) {

    operator fun invoke(id:String)= flow{
        detailScreenRepository.getSingleQuote(id).let {res->
            if (res.isSuccessful){
                emit( res.body())
            }
        }
    }
}