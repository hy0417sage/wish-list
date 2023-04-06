package com.hy0417sage.wishlist.ui.views.home.details

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hy0417sage.wishlist.data.model.WishEntity
import com.hy0417sage.wishlist.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("data", WishEntity::class.java)
        } else {
            intent.getParcelableExtra<WishEntity>("data")
        }

        Log.d("DetailsActivity", "$data")

        binding.button.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(data?.url)))
        }
    }
}