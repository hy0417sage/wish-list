package com.hy0417sage.wishlist.data.repository

import com.hy0417sage.wishlist.data.db.WishListDao
import com.hy0417sage.wishlist.data.model.WishEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WishListRepositoryImpl @Inject constructor(
    private val wishListDao: WishListDao,
) : WishListRepository {

    override val wholeWishList: Flow<List<WishEntity>>
        get() = wishListDao.getWishList()

    override suspend fun insertWish(wish: WishEntity) {
        wishListDao.insertWish(wish)
    }

    override suspend fun deleteWish(wish: WishEntity) {
        wishListDao.deleteWish(wish)
    }

    override fun searchQuery(query: String): Flow<List<WishEntity>> {
        return wishListDao.searchQuery(query)
    }
}