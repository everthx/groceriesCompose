package com.example.groceriescompose.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.groceriescompose.R
import com.example.groceriescompose.ui.models.UICategories

class CategoriesViewModel: ViewModel() {

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

    fun getImageIdFor(item: UICategories): Int {
        return when (item) {
            UICategories.Fruits -> R.drawable.ic_fruits
            UICategories.Vegetables -> R.drawable.ic_vegetables
            UICategories.Bread -> R.drawable.ic_grain
            UICategories.Dairy -> R.drawable.ic_milk
            UICategories.Meat -> R.drawable.ic_meat
            UICategories.Frozen -> R.drawable.ic_freezer
        }
    }

    fun getStringIdFor(item: UICategories): Int {
        return when (item) {
            UICategories.Fruits -> R.string.fruits
            UICategories.Vegetables -> R.string.vegetables
            UICategories.Bread -> R.string.bread_and_cereal
            UICategories.Dairy -> R.string.dairy
            UICategories.Meat -> R.string.meat
            UICategories.Frozen -> R.string.frozen
        }
    }
}