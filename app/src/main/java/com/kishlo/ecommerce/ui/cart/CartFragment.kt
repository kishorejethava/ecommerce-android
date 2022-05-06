package com.kishlo.ecommerce.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.kishlo.ecommerce.R
import com.kishlo.ecommerce.abstraction.Initialisation
import com.kishlo.ecommerce.databinding.FragmentCartBinding
import com.kishlo.ecommerce.ui.setTitle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment(), Initialisation {

    private lateinit var fragmentCartBinding: FragmentCartBinding
    private val viewModel: CartViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentCartBinding = FragmentCartBinding.inflate(inflater)
        fragmentCartBinding.viewModel = viewModel
        return fragmentCartBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun init() {
        setTitle(R.string.title_cart)
        val adapter = CartAdapter()
        fragmentCartBinding.rvCart.adapter = adapter
        viewModel.getCart()
        viewModel.liveDataCart.observe(viewLifecycleOwner) { response ->
            response?.let {
                adapter.setData(it)
            }
        }
        viewModel.liveDataCheckoutClick.observe(viewLifecycleOwner) {
            val action =
                CartFragmentDirections.actionCartFragmentToCheckoutFragment()
            findNavController().navigate(action)
        }
    }
}