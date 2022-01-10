package com.example.groceriescompose.domain.usecases

import com.example.groceriescompose.domain.repositories.ItemRepository

class ClearDatabaseUseCase(private val repository: ItemRepository) {

    suspend operator fun invoke() {
        return repository.clearDatabase()
    }
}