package com.example.groceriescompose.ui.screens.components

import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.groceriescompose.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.scaleMatrix
import com.example.groceriescompose.ui.theme.GroceriescomposeTheme

@ExperimentalAnimationApi
@Composable
fun ItemCard(item: String) {
    val isChecked = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .border(1.dp, Color.LightGray, RectangleShape)
            .padding(8.dp)
            .clickable { isChecked.value = !isChecked.value },
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = item, fontSize = 24.sp)

            AnimatedVisibility(visible = isChecked.value, enter = expandIn(expandFrom = Alignment.Center), exit = fadeOut(0.5f) ) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = null,
                    tint = colorResource(id = R.color.orange_500),
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
@Preview
fun ItemCardPreview() {
    GroceriescomposeTheme() {
        ItemCard(item = "Frooty Loopies")
    }
}