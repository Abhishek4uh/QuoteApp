package com.example.mywallet.presentation.screens.homeScreen.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.mywallet.domain.model.QuoteDC

@Composable
fun RandomQuoteItem(randomQuoteDC: QuoteDC) {
    QuoteItem(quoteDC=randomQuoteDC,bgColor = Color.Red, textColor = Color.White)
}