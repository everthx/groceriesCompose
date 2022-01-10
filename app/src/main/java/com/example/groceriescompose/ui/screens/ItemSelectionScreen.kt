package com.example.groceriescompose.ui.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceriescompose.R
import com.example.groceriescompose.ui.navigation.Screen
import com.example.groceriescompose.ui.screens.components.MakeTopBar
import com.example.groceriescompose.ui.theme.GroceriescomposeTheme
import com.example.groceriescompose.ui.viewmodels.ItemSelectionViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.groceriescompose.ui.screens.components.ItemCard

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun ItemSelectionScreen(
    navController: NavController,
    argument: String?,
    viewModel: ItemSelectionViewModel = viewModel()
) {

    val itemList: List<String> = viewModel.getItemsUnder(argument!!)

    Scaffold(
        topBar = {
            MakeTopBar(title = argument!!) {
                navController.navigate(Screen.CategoriesScreen.route) {
                    popUpTo(Screen.CategoriesScreen.route)
                    launchSingleTop = true
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = MaterialTheme.colors.primary
            ) {
                BottomNavigationItem(
                    selected = true,
                    onClick = {
                        navController.navigate(Screen.HomeScreen.route) {
                            popUpTo(Screen.HomeScreen.route)
                            launchSingleTop = true
                        }
                    },
                    label = { Text(text = "Save List") },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.AddCircle,
                            contentDescription = null
                        )
                    }
                )
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(itemList) { item ->
                ItemCard(item = item)
            }
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Preview
@Composable
fun ItemSelectionScreenPreview() {
    GroceriescomposeTheme() {
        ItemSelectionScreen(rememberNavController(), "Fruits", ItemSelectionViewModel())
    }
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Preview
@Composable
fun ItemSelectionDarkScreenPreview() {
    GroceriescomposeTheme(darkTheme = true) {
        ItemSelectionScreen(rememberNavController(), "Fruits", ItemSelectionViewModel())
    }
}