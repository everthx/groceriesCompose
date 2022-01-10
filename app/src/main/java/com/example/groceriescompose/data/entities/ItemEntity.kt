package com.example.groceriescompose.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemEntity(
    @PrimaryKey
    val id: Int? = null,
    val item: String,
    val category: String
)
