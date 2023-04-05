package com.hy0417sage.wishlist.ui.buylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BuyListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is BuyListFragment"
    }
    val text: LiveData<String> = _text
}