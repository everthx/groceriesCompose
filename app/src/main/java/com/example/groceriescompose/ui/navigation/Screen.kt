package com.example.groceriescompose.ui.navigation

sealed class Screen(val route: String) {
    object HomeScreen : Screen("Home")
    object CategoriesScreen : Screen("Categories")
}
