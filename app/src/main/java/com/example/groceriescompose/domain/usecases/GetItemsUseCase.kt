package com.example.groceriescompose.domain.usecases

import com.example.groceriescompose.data.entities.ItemEntity
import com.example.groceriescompose.domain.repositories.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetItemsUseCase(private val repository: ItemRepository) {

    operator fun invoke(): Flow<List<ItemEntity>> {
        return repository.getItems().map { item ->
            item.sortedBy { it.category }
        }
    }
}