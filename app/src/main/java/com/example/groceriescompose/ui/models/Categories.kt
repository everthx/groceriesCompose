package com.example.groceriescompose.ui.models


class Categories() {

    val categoriesList: List<UICategories> by lazy {
        getList()
    }

    private fun getList(): List<UICategories> {
        return listOf(
            UICategories.Fruits,
            UICategories.Vegetables,
            UICategories.Bread,
            UICategories.Dairy,
            UICategories.Meat,
            UICategories.Frozen
        )
    }
}

sealed class UICategories {
    object Fruits : UICategories()
    object Vegetables : UICategories()
    object Bread : UICategories()
    object Dairy : UICategories()
    object Meat : UICategories()
    object Frozen : UICategories()
}
