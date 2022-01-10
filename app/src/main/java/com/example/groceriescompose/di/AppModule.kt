package com.example.groceriescompose.di

import android.app.Application
import androidx.room.Room
import com.example.groceriescompose.data.database.ItemDatabase
import com.example.groceriescompose.data.repositories.ItemRepositoryImpl
import com.example.groceriescompose.domain.repositories.ItemRepository
import com.example.groceriescompose.domain.usecases.*
import com.example.groceriescompose.ui.viewmodels.CategoriesViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    @Provides
    @Singleton
    fun providesItemDatabase(app: Application): ItemDatabase {
        return Room.databaseBuilder(
            app,
            ItemDatabase::class.java,
            ItemDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providesItemRepository(db: ItemDatabase): ItemRepository {
        return ItemRepositoryImpl(db.itemDAO)
    }

    @Provides
    @Singleton
    fun providesItemUseCase(repository: ItemRepository): ItemUseCases {
        return ItemUseCases(
            getItemUseCase = GetItemsUseCase(repository),
            deleteItemUseCase = DeleteItemUseCase(repository),
            clearDatabaseUseCase = ClearDatabaseUseCase(repository),
            addItemUseCase = AddItemUseCase(repository)
        )
    }
}