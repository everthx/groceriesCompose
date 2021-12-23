package com.example.groceriescompose.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.groceriescompose.ui.screens.CategoriesScreen
import com.example.groceriescompose.ui.screens.HomeScreen

@ExperimentalFoundationApi
@Composable
fun ComposeNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route ){
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController = navController)
        }

        composable(route = Screen.CategoriesScreen.route){
            CategoriesScreen(navController = navController)
        }
    }
}