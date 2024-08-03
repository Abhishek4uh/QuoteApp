package com.example.mywallet.presentation.screens.detailScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mywallet.domain.model.QuoteDC
import com.example.mywallet.domain.useCase.SingleQuoteUseCase
import com.example.mywallet.utils.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailsVM @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val singleQuoteUseCase: SingleQuoteUseCase):ViewModel(){



    var singleQuote = MutableStateFlow<NetworkState<QuoteDC?>>(NetworkState.LOADING())
        private set

    init {
        getSingleQuoteById(savedStateHandle.get<String>("id")?:"")
    }

    private fun getSingleQuoteById(id: String) {
        singleQuote.tryEmit(NetworkState.LOADING())
        singleQuoteUseCase.invoke(id).onEach {data->
            singleQuote.tryEmit(NetworkState.SUCCESS(data))
        }.launchIn(viewModelScope)
    }
}