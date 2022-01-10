package com.example.groceriescompose.domain.repositories

import com.example.groceriescompose.data.entities.ItemEntity
import kotlinx.coroutines.flow.Flow

interface ItemRepository {

    fun getItems(): Flow<List<ItemEntity>>

    suspend fun getItemById(id: Int): ItemEntity?

    suspend fun insertItem(item: ItemEntity)

    suspend fun deleteItem(item: ItemEntity)

    suspend fun clearDatabase()
}