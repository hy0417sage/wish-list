package com.hy0417sage.wishlist.ui.views.home.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.hy0417sage.wishlist.databinding.ActivityDetailsBinding
import com.hy0417sage.wishlist.ui.base.BaseActivity
import com.hy0417sage.wishlist.ui.views.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : BaseActivity<ActivityDetailsBinding>(
    { ActivityDetailsBinding.inflate(it) }
) {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.dataUrl(intent.getStringExtra("url"))
        viewModel.wishItem.observe(this) { data ->
            Log.d("확인", "$data")
            Glide.with(binding.root)
                .load(data.image)
                .into(binding.imageView)
            binding.titleText.setText(data.title)
            binding.priceText.setText(data.price)
            binding.button.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(data.url)))
            }
        }
    }
}