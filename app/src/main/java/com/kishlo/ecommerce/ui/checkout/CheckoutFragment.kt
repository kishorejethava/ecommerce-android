package com.kishlo.ecommerce.ui.checkout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.kishlo.ecommerce.R
import com.kishlo.ecommerce.abstraction.Initialisation
import com.kishlo.ecommerce.databinding.FragmentCheckoutBinding
import com.kishlo.ecommerce.ui.setTitle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckoutFragment : DialogFragment(), Initialisation {

    private lateinit var fragmentCheckoutBinding: FragmentCheckoutBinding
    private val viewModel: CheckoutViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentCheckoutBinding = FragmentCheckoutBinding.inflate(inflater)
        fragmentCheckoutBinding.viewModel = viewModel
        return fragmentCheckoutBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun init() {
        setTitle(R.string.title_checkout)
        viewModel.liveDataContinueClick.observe(viewLifecycleOwner) {
            val action =
                CheckoutFragmentDirections.actionCheckoutFragmentToProductListFragment()
            findNavController().navigate(action)
        }
    }
}