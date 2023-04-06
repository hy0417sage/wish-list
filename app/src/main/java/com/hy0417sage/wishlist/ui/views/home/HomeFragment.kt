package com.hy0417sage.wishlist.ui.views.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.hy0417sage.wishlist.databinding.FragmentHomeBinding
import com.hy0417sage.wishlist.ui.base.BaseFragment
import com.hy0417sage.wishlist.ui.views.home.adapter.HomeAdapter
import com.hy0417sage.wishlist.ui.views.home.details.DetailsActivity

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val viewModel: HomeViewModel by activityViewModels()
    private val homeAdapter: HomeAdapter = HomeAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = homeAdapter
        }

        viewModel.wholeLikeUserData.observe(viewLifecycleOwner) { data ->
            homeAdapter.submitList(data)
        }

        homeAdapter.setItemClickListener { data ->
            startActivity(Intent(requireContext(), DetailsActivity::class.java).apply {
                putExtra("data", data)
            })
        }

        activity?.intent?.let { intent ->
            when (intent.action) {
                Intent.ACTION_SEND -> {
                    if (intent.type == "text/plain") {
                        val url = intent.getStringExtra(Intent.EXTRA_TEXT)
                        viewModel.insertWish(url)
                    }
                }
            }
        }
    }
}