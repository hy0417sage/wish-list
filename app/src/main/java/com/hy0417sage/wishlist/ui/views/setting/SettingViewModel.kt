package com.hy0417sage.wishlist.ui.views.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Setting"
    }
    val text: LiveData<String> = _text
}