package com.hy0417sage.wishlist.ui.views.home

import androidx.lifecycle.*
import com.hy0417sage.wishlist.data.model.WishEntity
import com.hy0417sage.wishlist.data.repository.WishListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import javax.inject.Inject

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Home"
    }
    val text: LiveData<String> = _text
}