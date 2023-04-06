package com.hy0417sage.wishlist.ui.views.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hy0417sage.wishlist.data.model.WishEntity
import com.hy0417sage.wishlist.databinding.LayoutWishListViewholderBinding

class HomeAdapter : ListAdapter<WishEntity, RecyclerView.ViewHolder>(HomeDiffUtil()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecyclerView.ViewHolder {
        return HomeViewHolder(
            LayoutWishListViewholderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
    ) {
        if (holder is HomeViewHolder) {
            val viewData = getItem(position) as WishEntity
            holder.bind(viewData)
        }
    }
}