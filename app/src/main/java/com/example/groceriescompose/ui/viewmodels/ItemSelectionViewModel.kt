package com.example.groceriescompose.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.groceriescompose.data.StockList
import com.example.groceriescompose.domain.mappers.StringCategoryToUICategoryMapper
import com.example.groceriescompose.ui.models.UICategory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemSelectionViewModel @Inject constructor() : ViewModel() {

    private val categoryMapper = StringCategoryToUICategoryMapper()

    fun getItemsUnder(category: String): List<String> {
        return when (categoryMapper.map(category)) {
            UICategory.Fruits -> StockList().getFruits()
            UICategory.Vegetables -> StockList().getVegetables()
            UICategory.Bread -> StockList().getBread()
            UICategory.Dairy -> StockList().getDairy()
            UICategory.Meat -> StockList().getMeat()
            UICategory.Frozen -> StockList().getFrozen()
        }
    }
}