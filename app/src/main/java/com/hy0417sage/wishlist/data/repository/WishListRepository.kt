package com.hy0417sage.wishlist.data.repository

import com.hy0417sage.wishlist.data.model.WishEntity
import kotlinx.coroutines.flow.Flow

interface WishListRepository {
    val wholeWishList: Flow<List<WishEntity>>
    suspend fun insertWish(wish: WishEntity)
    suspend fun deleteWish(wish: WishEntity)
    fun searchQuery(query: String): Flow<List<WishEntity>>
}