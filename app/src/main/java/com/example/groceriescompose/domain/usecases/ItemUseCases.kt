package com.example.groceriescompose.domain.usecases

data class ItemUseCases(
    val getItemUseCase: GetItemsUseCase,
    val deleteItemUseCase: DeleteItemUseCase,
    val clearDatabaseUseCase: ClearDatabaseUseCase,
    val addItemUseCase: AddItemUseCase
)
