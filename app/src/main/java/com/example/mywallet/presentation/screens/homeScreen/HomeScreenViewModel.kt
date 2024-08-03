package com.example.mywallet.presentation.screens.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mywallet.domain.model.HomeScreenDc
import com.example.mywallet.domain.model.QuoteDC
import com.example.mywallet.domain.useCase.AllQuoteUseCase
import com.example.mywallet.domain.useCase.RandomQuoteUseCase
import com.example.mywallet.utils.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject


@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val allQuoteUseCase: AllQuoteUseCase,
    private val randomQuoteUseCase: RandomQuoteUseCase):ViewModel(){

    var _quote= MutableStateFlow<NetworkState<HomeScreenDc>>(NetworkState.LOADING())
        private set


        init {
            getQuotes()
        }

    private fun getQuotes() {
        _quote.tryEmit(NetworkState.LOADING())
        allQuoteUseCase().combine(randomQuoteUseCase()){ a: List<QuoteDC?>?, b: QuoteDC? ->
            _quote.tryEmit(NetworkState.SUCCESS(HomeScreenDc(b,a)))
        }.launchIn(viewModelScope)
    }

}