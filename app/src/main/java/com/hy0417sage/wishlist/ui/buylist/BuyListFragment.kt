package com.hy0417sage.wishlist.ui.buylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hy0417sage.wishlist.databinding.FragmentBuyListBinding

class BuyListFragment : Fragment() {

    private var _binding: FragmentBuyListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val buyListViewModel =
            ViewModelProvider(this)[BuyListViewModel::class.java]

        _binding = FragmentBuyListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textBuyList
        buyListViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}