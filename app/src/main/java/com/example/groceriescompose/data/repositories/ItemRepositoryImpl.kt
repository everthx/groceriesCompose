package com.example.groceriescompose.data.repositories

import com.example.groceriescompose.data.database.ItemDAO
import com.example.groceriescompose.data.entities.ItemEntity
import com.example.groceriescompose.domain.repositories.ItemRepository
import kotlinx.coroutines.flow.Flow

class ItemRepositoryImpl(private val itemDao: ItemDAO): ItemRepository {

    override fun getItems(): Flow<List<ItemEntity>> = itemDao.getItems()

    override suspend fun getItemById(id: Int): ItemEntity? = itemDao.getItemById(id)

    override suspend fun insertItem(item: ItemEntity) = itemDao.insertItem(item)

    override suspend fun deleteItem(item: ItemEntity) = itemDao.deleteItem(item)

    override suspend fun clearDatabase() = itemDao.clearDatabase()
}