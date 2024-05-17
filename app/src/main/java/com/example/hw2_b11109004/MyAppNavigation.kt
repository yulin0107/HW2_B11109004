package com.example.hw2_b11109004

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyAppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.screenA) {
        composable(Routes.screenA,) {
            ScreenA(navController)
        }
        composable(Routes.screenB + "/{name}",) {

        }
    }
}