package com.kishlo.ecommerce.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kishlo.ecommerce.R
import com.kishlo.ecommerce.abstraction.Initialisation
import com.kishlo.ecommerce.databinding.FragmentCartBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment(), Initialisation {

    private lateinit var fragmentCartBinding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentCartBinding = FragmentCartBinding.inflate(inflater)
        return fragmentCartBinding.root
    }

    override fun init() {
        setTitle(R.string.title_cart)
    }
}