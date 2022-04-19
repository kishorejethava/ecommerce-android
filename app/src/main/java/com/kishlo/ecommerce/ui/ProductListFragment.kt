package com.kishlo.ecommerce.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kishlo.ecommerce.databinding.FragmentProductListBinding

class ProductListFragment : Fragment() {

    private lateinit var fragmentProductListBinding: FragmentProductListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentProductListBinding = FragmentProductListBinding.inflate(inflater)
        return fragmentProductListBinding.root
    }
}