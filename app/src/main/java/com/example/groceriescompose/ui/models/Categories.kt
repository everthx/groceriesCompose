package com.example.groceriescompose.ui.models

sealed class UICategories {
    object Fruits : UICategories()
    object Vegetables : UICategories()
    object Bread : UICategories()
    object Dairy : UICategories()
    object Meat : UICategories()
    object Frozen : UICategories()
}
