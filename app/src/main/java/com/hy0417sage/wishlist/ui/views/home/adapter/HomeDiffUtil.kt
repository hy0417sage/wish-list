package com.hy0417sage.wishlist.ui.views.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.hy0417sage.wishlist.data.model.WishEntity

class HomeDiffUtil : DiffUtil.ItemCallback<WishEntity>() {

    override fun areItemsTheSame(
        oldItem: WishEntity,
        newItem: WishEntity,
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: WishEntity,
        newItem: WishEntity,
    ): Boolean {
        return oldItem == newItem
    }
}