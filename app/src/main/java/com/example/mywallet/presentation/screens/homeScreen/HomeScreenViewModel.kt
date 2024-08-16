package com.example.mywallet.presentation.screens.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mywallet.common.Resource
import com.example.mywallet.common.extension.toErrorType
import com.example.mywallet.domain.model.AllQuoteDC
import com.example.mywallet.domain.model.HomeScreenDc
import com.example.mywallet.domain.model.QuoteDC
import com.example.mywallet.domain.useCase.AllQuoteUseCase
import com.example.mywallet.domain.useCase.RandomQuoteUseCase
import com.example.mywallet.presentation.commons.commonComponents.UiDataState
import com.example.mywallet.presentation.resource.ErrorTypeToErrorTextConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val allQuoteUseCase: AllQuoteUseCase,
    private val randomQuoteUseCase: RandomQuoteUseCase,
    private val errorTypeToErrorTextConverter: ErrorTypeToErrorTextConverter):ViewModel(){

    private val _quote = MutableStateFlow<UiDataState<HomeScreenDc>>(UiDataState.Loading())
    val quote: StateFlow<UiDataState<HomeScreenDc>> = _quote.asStateFlow()


        init {
            getQuotes()
        }

     fun getQuotes() {
        viewModelScope.launch {
            _quote.value = UiDataState.Loading()
            allQuoteUseCase().combine(randomQuoteUseCase()) { allQuotesResult: Resource<AllQuoteDC>, randomQuoteResult: Resource<QuoteDC> ->
                Pair(allQuotesResult, randomQuoteResult)
            }.catch { e ->
                _quote.value = UiDataState.Error(errorTypeToErrorTextConverter.convert(e.toErrorType()))
            }.collect { combinedResult ->

                val (allQuotesResult, randomQuoteResult) = combinedResult

                when {
                    allQuotesResult is Resource.Success && randomQuoteResult is Resource.Success -> {
                        //Both results are successful
                        _quote.value = UiDataState.Loaded(HomeScreenDc(randomQuoteResult.data,allQuotesResult.data))
                    }
                    allQuotesResult is Resource.Error -> {
                        //Handle error for allQuotes
                        _quote.value = UiDataState.Error(errorTypeToErrorTextConverter.convert(allQuotesResult.error))
                    }
                    randomQuoteResult is Resource.Error -> {
                        //Handle error for randomQuote
                        _quote.value = UiDataState.Error(errorTypeToErrorTextConverter.convert(randomQuoteResult.error))
                    }
                }
            }
        }
    }
}