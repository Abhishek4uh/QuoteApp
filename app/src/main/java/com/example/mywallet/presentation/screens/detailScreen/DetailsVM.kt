package com.example.mywallet.presentation.screens.detailScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mywallet.common.Resource
import com.example.mywallet.domain.model.QuoteDC
import com.example.mywallet.domain.useCase.SingleQuoteUseCase
import com.example.mywallet.presentation.commons.commonComponents.UiDataState
import com.example.mywallet.presentation.resource.ErrorTypeToErrorTextConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsVM @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val singleQuoteUseCase: SingleQuoteUseCase,
    private val errorTypeToErrorTextConverter: ErrorTypeToErrorTextConverter):ViewModel(){



    private val _singleQuote = MutableStateFlow<UiDataState<QuoteDC>>(UiDataState.Loading())
    val singleQuote: StateFlow<UiDataState<QuoteDC>> = _singleQuote.asStateFlow()


    init {
        getSingleQuoteById(savedStateHandle.get<String>("id")?:"")
    }

     fun getSingleQuoteById(id: String) {
         viewModelScope.launch {
             _singleQuote.value= UiDataState.Loading()
             singleQuoteUseCase.invoke(id)
                 .catch {}
                 .collect {
                     when (it) {
                         is Resource.Success -> _singleQuote.value = UiDataState.Loaded(it.data)
                         is Resource.Error -> _singleQuote.value = UiDataState.Error(errorTypeToErrorTextConverter.convert(it.error))
                     }
                 }
         }
    }
}