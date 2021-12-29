package com.example.groceriescompose.mappers

import com.example.groceriescompose.common.Mapper
import com.example.groceriescompose.ui.models.UICategory

class StringCategoryToUICategoryMapper : Mapper<String, UICategory> {
    override fun map(input: String): UICategory {
        return when (input) {
            "Fruits" -> UICategory.Fruits
            "Vegetables" -> UICategory.Vegetables
            "Bread and Cereal" -> UICategory.Bread
            "Dairy" -> UICategory.Dairy
            "Meat" -> UICategory.Meat
            else -> UICategory.Frozen
        }
    }
}