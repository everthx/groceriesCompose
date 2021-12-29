package com.example.groceriescompose.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.groceriescompose.ui.screens.CategoriesScreen
import com.example.groceriescompose.ui.screens.HomeScreen
import com.example.groceriescompose.ui.screens.ItemSelectionScreen
import com.example.groceriescompose.ui.viewmodels.CategoriesViewModel
import com.example.groceriescompose.ui.viewmodels.ItemSelectionViewModel

@ExperimentalFoundationApi
@Composable
fun ComposeNavigation() {
    val navController = rememberNavController()
    val categoriesViewModel = CategoriesViewModel()
    val itemSelectionViewModel = ItemSelectionViewModel()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController)
        }

        composable(route = Screen.CategoriesScreen.route) {
            CategoriesScreen(navController, categoriesViewModel)
        }

        composable(route = Screen.SelectionScreen.route + "/{category}") {
            ItemSelectionScreen(
                navController,
                it.arguments?.getString("category"),
                itemSelectionViewModel
            )
        }
    }
}