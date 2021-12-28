package com.example.groceriescompose.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceriescompose.R
import com.example.groceriescompose.ui.models.Categories
import com.example.groceriescompose.ui.models.UICategories
import com.example.groceriescompose.ui.navigation.Screen
import com.example.groceriescompose.ui.theme.GroceriescomposeTheme

private val categories = Categories().categoriesList

@ExperimentalFoundationApi
@Composable
fun CategoriesScreen(navController: NavController) {

    Column() {
        TopAppBar(
            title = { Text(text = stringResource(id = R.string.categories)) },
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

        Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(items = categories) { item ->
                    val itemName = stringResource(id = getStringIdFor(item))

                    Card(
                        modifier = Modifier
                            .size(width = 50.dp, height = 150.dp)
                            .padding(4.dp)
                            .clickable {
                                navController.navigate(Screen.SelectionScreen.route + "/${itemName}")
                            },
                        backgroundColor = Color(red = 40, green = 209, blue = 189),
                        shape = RoundedCornerShape(5.dp),
                        elevation = 8.dp
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                modifier = Modifier.size(80.dp),
                                painter = painterResource(id = getImageIdFor(item)),
                                contentDescription = null
                            )
                            Text(
                                text = itemName, textAlign = TextAlign.Center,
                                fontSize = 16.sp, modifier = Modifier.padding(4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun getImageIdFor(item: UICategories): Int {
    return when (item) {
        UICategories.Fruits -> R.drawable.ic_fruits
        UICategories.Vegetables -> R.drawable.ic_vegetables
        UICategories.Bread -> R.drawable.ic_grain
        UICategories.Dairy -> R.drawable.ic_milk
        UICategories.Meat -> R.drawable.ic_meat
        UICategories.Frozen -> R.drawable.ic_freezer
    }
}

private fun getStringIdFor(item: UICategories): Int {
    return when (item) {
        UICategories.Fruits -> R.string.fruits
        UICategories.Vegetables -> R.string.vegetables
        UICategories.Bread -> R.string.bread_and_cereal
        UICategories.Dairy -> R.string.dairy
        UICategories.Meat -> R.string.meat
        UICategories.Frozen -> R.string.frozen
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun CategoriesScreenPreview() {
    GroceriescomposeTheme() {
        CategoriesScreen(navController = rememberNavController())
    }
}

@ExperimentalFoundationApi
@Preview(locale = "ES")
@Composable
fun CategoriesDarkScreenPreview() {
    GroceriescomposeTheme(darkTheme = true) {
        CategoriesScreen(navController = rememberNavController())
    }
}