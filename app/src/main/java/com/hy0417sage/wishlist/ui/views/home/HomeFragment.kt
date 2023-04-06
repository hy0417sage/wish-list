package com.hy0417sage.wishlist.ui.views.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.hy0417sage.wishlist.databinding.FragmentHomeBinding
import com.hy0417sage.wishlist.ui.views.home.adapter.HomeAdapter
import com.hy0417sage.wishlist.ui.views.home.details.DetailsActivity

class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by activityViewModels()
    private val homeAdapter: HomeAdapter = HomeAdapter()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

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