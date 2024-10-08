package com.example.mywallet.presentation.commons.commonComponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolBarComponent(
    title:String,
    showBackButton:Boolean=false,
    onBackPress:()->Unit={},
    scrollBehavior: TopAppBarScrollBehavior) {
    TopAppBar(
        title = {
            Text(
                text = title,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.W800,
                color = Color.White
                )
        },
        navigationIcon = {
            if (showBackButton){
                IconButton(onClick = onBackPress) {
                    Icon(Icons.Default.ArrowBack,
                        contentDescription ="Back" ,
                        tint = Color.White,
                        modifier = Modifier
                            .size(32.dp)
                            .padding(5.dp))
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.onPrimary,
           scrolledContainerColor = MaterialTheme.colorScheme.onPrimary),
        scrollBehavior = scrollBehavior
    )
}