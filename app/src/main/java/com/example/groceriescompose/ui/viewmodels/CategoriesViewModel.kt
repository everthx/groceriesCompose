package com.example.groceriescompose.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.groceriescompose.R
import com.example.groceriescompose.domain.usecases.ItemUseCases
import com.example.groceriescompose.ui.models.UICategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor() : ViewModel() {

    @Inject lateinit var itemUseCases: ItemUseCases

    val categoriesList: List<UICategory> by lazy {
        getList()
    }

    private fun getList(): List<UICategory> {
        return listOf(
            UICategory.Fruits,
            UICategory.Vegetables,
            UICategory.Bread,
            UICategory.Dairy,
            UICategory.Meat,
            UICategory.Frozen
        )
    }

    fun test(){
        viewModelScope.launch {
            val result = itemUseCases.clearDatabaseUseCase
        }
    }

    fun getImageIdFor(item: UICategory): Int {
        return when (item) {
            UICategory.Fruits -> R.drawable.ic_fruits
            UICategory.Vegetables -> R.drawable.ic_vegetables
            UICategory.Bread -> R.drawable.ic_grain
            UICategory.Dairy -> R.drawable.ic_milk
            UICategory.Meat -> R.drawable.ic_meat
            UICategory.Frozen -> R.drawable.ic_freezer
        }
    }

    fun getStringIdFor(item: UICategory): Int {
        return when (item) {
            UICategory.Fruits -> R.string.fruits
            UICategory.Vegetables -> R.string.vegetables
            UICategory.Bread -> R.string.bread_and_cereal
            UICategory.Dairy -> R.string.dairy
            UICategory.Meat -> R.string.meat
            UICategory.Frozen -> R.string.frozen
        }
    }
}