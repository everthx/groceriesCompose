package com.example.groceriescompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceriescompose.R
import com.example.groceriescompose.ui.navigation.Screen
import com.example.groceriescompose.ui.theme.GroceriescomposeTheme

@Composable
fun HomeScreen(navController: NavController) {
    Surface(color = MaterialTheme.colors.background, elevation = 2.dp) {

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_groceries_main),
                contentDescription = null,
                modifier = Modifier.padding(16.dp).size(240.dp).clip(CircleShape)
            )

            Text(
                text = stringResource(id = R.string.welcome_to_groceries_app),
                fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(16.dp)
            )

            Button(
                onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Text(text = stringResource(id = R.string.view_current_screen))
            }

            Button(
                onClick = { navController.navigate(Screen.CategoriesScreen.route) },
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Text(text = stringResource(id = R.string.create_add_to_list))
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    GroceriescomposeTheme() {
        HomeScreen(rememberNavController())
    }
}

@Preview
@Composable
fun HomeScreenDarkPreview() {
    GroceriescomposeTheme(darkTheme = true) {
        HomeScreen(rememberNavController())
    }
}