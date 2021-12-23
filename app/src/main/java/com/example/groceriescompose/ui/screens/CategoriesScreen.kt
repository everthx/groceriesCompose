package com.example.groceriescompose.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceriescompose.R
import com.example.groceriescompose.ui.navigation.Screen

val categories = listOf("Fruits", "Vegetables", "Bread and Cereal", "Dairy", "Meats", "Frozen")

@ExperimentalFoundationApi
@Composable
fun CategoriesScreen(navController: NavController) {
    Column() {
        TopAppBar(
            title = { Text(text = Screen.CategoriesScreen.route) },
            backgroundColor = MaterialTheme.colors.primary,
            navigationIcon = {
                IconButton(onClick = { navController.navigate(Screen.HomeScreen.route) }) {
                    Icon(
                        painterResource(id = R.drawable.ic_arrow_back_24),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        )

        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(items = categories) { item ->
                    Card(
                        modifier = Modifier
                            .size(width = 50.dp, height = 150.dp)
                            .padding(4.dp)
                            .clickable { },
                        backgroundColor = Color(
                            red = 255,
                            green = 165,
                            blue = 0
                        ),
                        shape = RoundedCornerShape(5.dp),
                        elevation = 8.dp
                    ) {
                        Text(
                            text = item,
                            textAlign = TextAlign.Center,
                            fontSize = 24.sp,
                            modifier = Modifier.padding(16.dp)
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
fun CategoriesScreenPreview() {
    val nav = rememberNavController()
    CategoriesScreen(navController = nav)
}