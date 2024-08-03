package com.example.mywallet.presentation.screens.homeScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mywallet.domain.model.HomeScreenDc

@Composable
fun HomeBody(homeScreenDc: HomeScreenDc, onClick:(id:String)->Unit) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)){

        homeScreenDc.randomQuoteDC?.let {
            item{
                HeadingTitle(title ="Random Quote")
                RandomQuoteItem(homeScreenDc.randomQuoteDC)
            }
        }

        item {
            HeadingTitle(title ="Quotes")
        }
        items(homeScreenDc.allQuoteDC?: emptyList()){item ->  
            QuoteItem(quoteDC = item!!, modifier = Modifier.clickable {
                onClick.invoke(item.id.toString())
            })
        }

    }
}