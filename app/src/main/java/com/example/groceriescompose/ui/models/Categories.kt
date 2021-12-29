package com.example.groceriescompose.ui.models

sealed class UICategory(val name: String) {
    object Fruits : UICategory("Fruits")
    object Vegetables : UICategory("Vegetables")
    object Bread : UICategory("Bread and Cereal")
    object Dairy : UICategory("Dairy")
    object Meat : UICategory("Meat")
    object Frozen : UICategory("Frozen")
}
