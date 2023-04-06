package com.hy0417sage.wishlist.ui.views.home.details

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import com.bumptech.glide.Glide
import com.hy0417sage.wishlist.data.model.WishEntity
import com.hy0417sage.wishlist.databinding.ActivityDetailsBinding
import com.hy0417sage.wishlist.ui.base.BaseActivity

class DetailsActivity : BaseActivity<ActivityDetailsBinding>(
    { ActivityDetailsBinding.inflate(it) }
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("data", WishEntity::class.java)
        } else {
            intent.getParcelableExtra<WishEntity>("data")
        }

        binding.button.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(data?.url)))
        }

        Glide.with(binding.root)
            .load(data?.image)
            .into(binding.imageView)

        binding.titleText.setText(data?.title)
        binding.priceText.setText(data?.price)
    }
}