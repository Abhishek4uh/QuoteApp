package com.example.mywallet.presentation.screens.detailScreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mywallet.presentation.commons.commonComponents.MyProgressBar
import com.example.mywallet.presentation.commons.commonComponents.ToolBarComponent
import com.example.mywallet.presentation.screens.detailScreen.components.DetailsQuoteCard
import com.example.mywallet.utils.NetworkState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(detailsVM: DetailsVM= hiltViewModel(),onBackPress:()->Unit) {

    val state= detailsVM.singleQuote.collectAsStateWithLifecycle().value
    val scrollBehavior= TopAppBarDefaults.enterAlwaysScrollBehavior(state= rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            ToolBarComponent(
                title = "Details",
                scrollBehavior=scrollBehavior,
                showBackButton = true,
                onBackPress = onBackPress)
        })
    {paddingValues ->
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.LightGray)){

            when(state){
                is NetworkState.ERROR -> {
                    Log.d("DetailsScreen_Composable","Error Occurred")
                }
                is NetworkState.LOADING -> {
                    MyProgressBar()
                }
                is NetworkState.SUCCESS -> {
                    DetailsQuoteCard(state.data!!)
                }
            }
        }
    }
}


@Preview
@Composable
private fun DetailsScreenPreview() {
    DetailsScreen(onBackPress = {})
}