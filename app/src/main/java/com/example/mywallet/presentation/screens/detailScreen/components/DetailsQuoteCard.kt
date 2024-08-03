package com.example.mywallet.presentation.screens.detailScreen.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
fun DetailsQuoteCard(data:QuoteDC){

    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
            .padding(15.dp)
    ){

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center) {

            Text(text = data.quote?:"empty",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                color = Color.Black,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp)
            Spacer(modifier = Modifier.height(5.dp))


            Text(text = data.author?:"empty",
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black,
                textAlign = TextAlign.End,
                fontWeight = FontWeight.W300,
                fontSize = 12.sp)
        }
    }
}
