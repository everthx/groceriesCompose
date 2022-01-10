package com.example.groceriescompose.domain.mappers

import com.example.groceriescompose.common.Mapper
import com.example.groceriescompose.domain.exeptions.InvalidItemException
import com.example.groceriescompose.ui.models.UICategory
import kotlin.jvm.Throws

class StringCategoryToUICategoryMapper : Mapper<String, UICategory> {

    @Throws(InvalidItemException::class)
    override fun map(input: String): UICategory {
        return when (input) {
            "Fruits" -> UICategory.Fruits
            "Vegetables" -> UICategory.Vegetables
            "Bread and Cereal" -> UICategory.Bread
            "Dairy" -> UICategory.Dairy
            "Meat" -> UICategory.Meat
            "Frozen" -> UICategory.Frozen
            else -> throw InvalidItemException("Invalid Item Category")
        }
    }
}