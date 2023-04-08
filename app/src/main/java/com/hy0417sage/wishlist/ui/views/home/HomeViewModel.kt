package com.hy0417sage.wishlist.ui.views.home

import android.util.Log
import androidx.lifecycle.*
import com.hy0417sage.wishlist.data.model.WishEntity
import com.hy0417sage.wishlist.data.repository.WishListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val wishListRepository: WishListRepository,
) : ViewModel() {

    val wholeWishListData: LiveData<List<WishEntity>> =
        wishListRepository.wholeWishList.asLiveData()

    private val _wishItem = MutableLiveData<WishEntity>()
    val wishItem: LiveData<WishEntity> get() = _wishItem

    fun dataUrl(URL: String?) {
        val map = mutableMapOf<String, String>()
        viewModelScope.launch(Dispatchers.IO) {
            val doc = Jsoup.connect(URL).get()
            val total = doc.select("meta[property^=og:]")
            for (i in 0 until total.size) {
                val tag = total[i]
                when (tag.attr("property")) {
                    "og:url" -> {
                        map["url"] = tag.attr("content")
                    }
                    "og:title" -> {
                        map["title"] = tag.attr("content")
                    }
                    "og:image" -> {
                        map["image"] = tag.attr("content")
                    }
                    "og:description" -> {
                        map["description"] = tag.attr("content")
                    }
                }
            }
            Log.d("HomeViewModel", "$map")
            _wishItem.postValue(WishEntity(
                id = null,
                title = map["title"],
                image = map["image"],
                type = "beauty",
                price = "",
                reasons = "",
                url = URL,
            ))
        }
    }

    fun insertWish(wishEntity: WishEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            wishListRepository.insertWish(wishEntity)
        }
    }

    fun deleteWish(wishEntity: WishEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            wishListRepository.deleteWish(wishEntity)
        }
    }

    fun searchQuery(query: String): LiveData<List<WishEntity>> {
        return wishListRepository.searchQuery(query).asLiveData()
    }
}