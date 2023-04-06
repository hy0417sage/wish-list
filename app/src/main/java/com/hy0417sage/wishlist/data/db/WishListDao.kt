package com.hy0417sage.wishlist.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.hy0417sage.wishlist.data.model.WishEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WishListDao {

    @Query("SELECT * FROM wish_list")
    fun getWishList(): Flow<List<WishEntity>>

    @Insert
    suspend fun insertWish(wish: WishEntity)

    @Delete
    suspend fun deleteWish(wish: WishEntity)
}