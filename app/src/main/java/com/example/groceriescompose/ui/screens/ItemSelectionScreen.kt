package com.example.groceriescompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceriescompose.R
import com.example.groceriescompose.ui.navigation.Screen
import com.example.groceriescompose.ui.theme.GroceriescomposeTheme

@Composable
fun ItemSelectionScreen(navController: NavController) {
    Column {
        TopAppBar(
            title = { Text(text = stringResource(id = R.string.fruits)) },
            backgroundColor = MaterialTheme.colors.primary,
            navigationIcon = {
                IconButton(onClick = { navController.navigate(Screen.CategoriesScreen.route) }) {
                    Icon(
                        painterResource(id = R.drawable.ic_arrow_back_24),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        )

        for (number in 0..5){
            Row(modifier = Modifier.padding(16.dp)) {
                Text(text = "Hello $number")
            }
        }

    }
}


@Preview
@Composable
fun ItemSelectionScreenPreview() {
    val nav = rememberNavController()
    ItemSelectionScreen(nav)
}


@Preview
@Composable
fun ItemSelectionDarkScreenPreview() {
    GroceriescomposeTheme(darkTheme = true) {
        val nav = rememberNavController()
        ItemSelectionScreen(nav)
    }
}