package com.example.groceriescompose.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
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
import com.example.groceriescompose.ui.theme.GroceriescomposeTheme

private val itemList: List<String> =
    listOf(
        "Apple", "Banana", "Peach", "Carrots", "Potatoes", "Milk", "Eggs", "Tomatoes", "Zucaritas",
        "Apple", "Banana", "Peach", "Carrots", "Potatoes", "Milk", "Eggs", "Tomatoes", "Zucaritas",
        "Apple", "Banana", "Peach", "Carrots", "Potatoes", "Milk", "Eggs", "Tomatoes", "Zucaritas"
    )

@ExperimentalFoundationApi
@Composable
fun ItemSelectionScreen(navController: NavController, argument: String?) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = argument!!) },
                backgroundColor = MaterialTheme.colors.primary,
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(Screen.CategoriesScreen.route) }) {
                        Icon(
                            painterResource(id = R.drawable.ic_arrow_back_24),
                            contentDescription = null, modifier = Modifier.size(30.dp)
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                modifier = Modifier.wrapContentHeight()
            ) {
                BottomNavigationItem(
                    selected = true,
                    onClick = {
                        navController.navigate(Screen.HomeScreen.route) { popUpTo(Screen.HomeScreen.route) }
                    },
                    label = { Text(text = "Save List") },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_check_circle_24),
                            contentDescription = null
                        )
                    })
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(itemList) { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color.LightGray, CircleShape)
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = item, modifier = Modifier.padding(8.dp))

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_check_circle_24),
                            tint = colorResource(id = R.color.orange_500),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun ItemSelectionScreenPreview() {
    GroceriescomposeTheme() {
        ItemSelectionScreen(rememberNavController(), "Fruits")
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun ItemSelectionDarkScreenPreview() {
    GroceriescomposeTheme(darkTheme = true) {
        ItemSelectionScreen(rememberNavController(), "Fruits")
    }
}