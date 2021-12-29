package com.example.groceriescompose.ui.screens.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.groceriescompose.R

@Composable
fun MakeTopBar(title: String, backNavigation: () -> Unit) {
    TopAppBar(
        title = { Text(text = title) },
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = {
            IconButton(onClick = backNavigation) {
                Icon(
                    painterResource(id = R.drawable.ic_arrow_back_24),
                    contentDescription = null, modifier = Modifier.size(30.dp)
                )
            }
        }
    )
}