package com.hy0417sage.wishlist.ui.views.buylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BuyListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "BuyList"
    }
    val text: LiveData<String> = _text
}