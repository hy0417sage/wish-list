package com.hy0417sage.wishlist.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hy0417sage.wishlist.data.model.WishEntity

@Database(
    entities = [WishEntity::class],
    version = 1,
    exportSchema = false)
abstract class WishListDataBase : RoomDatabase() {
    abstract fun getWishListDao(): WishListDao
}