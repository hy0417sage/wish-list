package com.hy0417sage.wishlist.ui.views.home.details

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.hy0417sage.wishlist.data.model.WishEntity
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

        val data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("data", WishEntity::class.java)
        } else {
            intent.getParcelableExtra<WishEntity>("data")
        }

        if (data != null) {
            Glide.with(binding.root)
                .load(data.image)
                .into(binding.imageView)
            binding.titleText.setText(data.title)
            binding.priceText.setText(data.price)
            binding.button.setOnClickListener {
                viewModel.insertWish(data) //저장하기
                val text = "Item 을 저장하였습니다."
                Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
            }
        }
    }
}