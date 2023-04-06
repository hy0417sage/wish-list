package com.hy0417sage.wishlist.ui.views.buylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hy0417sage.wishlist.databinding.FragmentBuyListBinding

class BuyListFragment : Fragment() {

    private var _binding: FragmentBuyListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBuyListBinding.inflate(inflater, container, false)
        return binding.root
    }
}