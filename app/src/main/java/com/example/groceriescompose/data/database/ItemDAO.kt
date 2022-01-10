package com.example.groceriescompose.data.database

import androidx.room.*
import com.example.groceriescompose.data.entities.ItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDAO {

    @Query("SELECT * FROM itementity")
    fun getItems(): Flow<List<ItemEntity>>

    @Query("SELECT * FROM itementity WHERE id = :id")
    suspend fun getItemById(id: Int): ItemEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: ItemEntity)

    @Delete
    suspend fun deleteItem(item: ItemEntity)

    @Query("DELETE FROM itementity")
    suspend fun clearDatabase()
}