package com.example.mywallet.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import com.google.accompanist.systemuicontroller.rememberSystemUiController


val DarkColorScheme = darkColorScheme(
    primary = White,
    onPrimary = Black,
    secondary = White,
    background = Black
)


 val LightColorScheme = lightColorScheme(
     primary = Green,
     onPrimary = Green,
     secondary = Black,
     background = White
)

@Composable
fun MyWalletTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    val view= LocalView.current
    if (!view.isInEditMode){
        val systemUiController= rememberSystemUiController()
        val statusBarColor= if(isSystemInDarkTheme()){
            Black
        }
        else{
            Green
        }

        val navigationBarColor=if(isSystemInDarkTheme()){
            Black
        }
        else{
            White
        }

        SideEffect {
            systemUiController.setStatusBarColor(statusBarColor)
            systemUiController.setNavigationBarColor(navigationBarColor)
        }
    }
    MaterialTheme(colorScheme = colors, typography = Typography, content = content)
}