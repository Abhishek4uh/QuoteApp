package com.example.mywallet.presentation.screens.homeScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mywallet.domain.model.QuoteDC


@Composable
fun QuoteItem(
    quoteDC: QuoteDC,
    modifier: Modifier=Modifier,
    bgColor:Color= Color.White,
    textColor:Color= Color.Black) {


    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp), elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(containerColor = bgColor)){

        Column(
            horizontalAlignment = Alignment.Start
             ,verticalArrangement = Arrangement.Center
            ,modifier= Modifier
                .fillMaxWidth()
                .padding(10.dp)) {
            Text(
                text = quoteDC.quote?:"",
                modifier = Modifier.fillMaxWidth(),
                color = textColor,
                textAlign = TextAlign.Justify,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = quoteDC.author?:"",
                modifier = Modifier.fillMaxWidth(),
                color = textColor,
                textAlign = TextAlign.End,
                fontSize = 12.sp,
                fontWeight = FontWeight.W300
            )
        }
    }
}
