package com.example.mywallet.presentation.commons.appNavigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mywallet.presentation.screens.detailScreen.DetailsScreen
import com.example.mywallet.presentation.screens.homeScreen.HomeScreen
import com.example.mywallet.utils.AppScreens

@Composable
fun AppNavigation() {

    val navController= rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.HOME_SCREEN ){
        composable(
            route= AppScreens.HOME_SCREEN,
            exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left
            )},
            popEnterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right)
            }){
            HomeScreen{id->
                navController.navigate(AppScreens.DETAIL_SCREEN+"/$id")
            }
        }


        composable(
            route= AppScreens.DETAIL_SCREEN+"/{id}",
            arguments = listOf(navArgument(name = "id"){
                type= NavType.StringType
            }),
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right
                )
            }){navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getString("id") ?: ""

            DetailsScreen(id = id,onBackPress = {
                navController.popBackStack()
            })
        }
    }
}