package com.example.groceriescompose.domain.usecases

import com.example.groceriescompose.data.entities.ItemEntity
import com.example.groceriescompose.domain.repositories.ItemRepository

class DeleteItemUseCase(private val repository: ItemRepository) {

    suspend operator fun invoke(item: ItemEntity) {
        repository.deleteItem(item)
    }
}