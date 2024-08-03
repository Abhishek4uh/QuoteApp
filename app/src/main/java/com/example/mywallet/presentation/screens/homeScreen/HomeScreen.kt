package com.example.mywallet.presentation.screens.homeScreen


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mywallet.presentation.commons.commonComponents.MyProgressBar
import com.example.mywallet.presentation.commons.commonComponents.ToolBarComponent
import com.example.mywallet.presentation.screens.homeScreen.components.HomeBody
import com.example.mywallet.utils.NetworkState



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(homeScreenViewModel: HomeScreenViewModel= hiltViewModel(), onClick:(id:String)->Unit) {

    val state= homeScreenViewModel._quote.collectAsStateWithLifecycle().value

    val scrollBehavior= TopAppBarDefaults.enterAlwaysScrollBehavior(state= rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.fillMaxSize().nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = { ToolBarComponent("DailyQuote", scrollBehavior=scrollBehavior) }){ paddingValues ->

        Box(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center){

            when(state){
                is NetworkState.ERROR -> {
                    Log.d("HomeScreen_Composable","Error Occurred")
                }
                is NetworkState.LOADING -> {
                    MyProgressBar()
                }
                is NetworkState.SUCCESS -> {
                    HomeBody(state.data,onClick = onClick)
                }
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(onClick = {})
}
