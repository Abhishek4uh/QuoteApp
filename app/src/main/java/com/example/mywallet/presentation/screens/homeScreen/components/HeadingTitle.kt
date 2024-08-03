package com.example.mywallet.presentation.screens.homeScreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HeadingTitle(title:String) {
    Text(text = title,
        modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp, horizontal = 6.dp),
        fontWeight = FontWeight.W800,
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        color = MaterialTheme.colorScheme.secondary)
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HeadingTitlePreview() {
    HeadingTitle("Random quote")
}