package com.hy0417sage.wishlist.data.di

import android.content.Context
import androidx.room.Room
import com.hy0417sage.wishlist.data.db.WishListDao
import com.hy0417sage.wishlist.data.db.WishListDataBase
import com.hy0417sage.wishlist.data.repository.WishListRepositoryImpl
import com.hy0417sage.wishlist.data.repository.WishListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class WishListDI {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): WishListDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            WishListDataBase::class.java,
            "wish_list.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideDao(
        appDataBase: WishListDataBase,
    ): WishListDao {
        return appDataBase.getWishListDao()
    }

    @Singleton
    @Provides
    fun provideRepository(
        wishDao: WishListDao,
    ): WishListRepository {
        return WishListRepositoryImpl(wishDao)
    }
}
