package com.hy0417sage.wishlist.ui.views.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hy0417sage.wishlist.data.model.WishEntity
import com.hy0417sage.wishlist.databinding.LayoutWishListViewholderBinding

class HomeViewHolder(
    private val binding: LayoutWishListViewholderBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(wish: WishEntity) {
        with(binding) {
            titleText.text = wish.title
            binding.imageView.clipToOutline = true
            Glide.with(binding.root)
                .load(wish.image)
                .into(binding.imageView)
        }
    }
}