package com.example.mywallet.presentation.commons.commonComponents

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun ErrorView(errorText: ErrorText, action: () -> Unit) {
    AlertDialog(
        onDismissRequest = { /*Prevent dismissing by clicking outside the dialog */ },
        title = {
            Text(text = "Error Occurred")
        },
        text = {
            Text(text = errorText.asString())
        },
        confirmButton = {
            Button(
                onClick = { action() }
            ) {
                Text("Retry",  color = MaterialTheme.colorScheme.background)
            }
        }
    )
}