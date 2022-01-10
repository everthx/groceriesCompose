package com.example.groceriescompose.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.groceriescompose.data.entities.ItemEntity

@Database(
    entities = [ItemEntity::class],
    version = 1
)
abstract class ItemDatabase: RoomDatabase() {

    abstract val itemDAO: ItemDAO

    companion object {
        const val DATABASE_NAME = "item_db"
    }
}