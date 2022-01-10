package com.example.groceriescompose.domain.usecases

import com.example.groceriescompose.data.entities.ItemEntity
import com.example.groceriescompose.domain.exeptions.InvalidItemException
import com.example.groceriescompose.domain.repositories.ItemRepository

class AddItemUseCase(private val repository: ItemRepository) {

    @Throws(InvalidItemException::class)
    suspend operator fun invoke(item: ItemEntity) {
        if (item.item.isNullOrBlank()) throw InvalidItemException("Name must not be empty")
        if (item.category.isNullOrBlank()) throw InvalidItemException("Category must not be empty")

        repository.insertItem(item)
    }
}