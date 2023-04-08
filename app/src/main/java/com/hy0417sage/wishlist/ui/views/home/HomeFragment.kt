package com.hy0417sage.wishlist.ui.views.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.hy0417sage.wishlist.R
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

        viewModel.wholeWishListData.observe(viewLifecycleOwner) { data ->
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
                        viewModel.dataUrl(url)
                        viewModel.wishItem.observe(viewLifecycleOwner){ data ->
                            startActivity(Intent(requireContext(), DetailsActivity::class.java).apply {
                                putExtra("data", data)
                            })
                        }
                    }
                }
            }
        }

        binding.filterChipGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.chip_all -> {
                    viewModel.wholeWishListData.observe(viewLifecycleOwner) { data ->
                        homeAdapter.submitList(data)
                    }
                }
                R.id.chip_beauty -> {
                    viewModel.searchQuery("beauty").observe(viewLifecycleOwner) { data ->
                        homeAdapter.submitList(data)
                    }
                }
                R.id.chip_fashion -> {
                    viewModel.searchQuery("fashion").observe(viewLifecycleOwner) { data ->
                        homeAdapter.submitList(data)
                    }
                }
                R.id.chip_tech -> {
                    viewModel.searchQuery("tech").observe(viewLifecycleOwner) { data ->
                        homeAdapter.submitList(data)
                    }
                }
                R.id.chip_other -> {
                    viewModel.searchQuery("other").observe(viewLifecycleOwner) { data ->
                        homeAdapter.submitList(data)
                    }
                }
            }
        }

    }
}