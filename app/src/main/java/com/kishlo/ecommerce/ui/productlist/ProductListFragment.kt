package com.kishlo.ecommerce.ui.productlist

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.kishlo.ecommerce.R
import com.kishlo.ecommerce.abstraction.Initialisation
import com.kishlo.ecommerce.databinding.FragmentProductListBinding
import com.kishlo.ecommerce.ui.setTitle
import com.kishlo.ecommerce.util.EqualSpacingItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment(), Initialisation {

    private lateinit var fragmentProductListBinding: FragmentProductListBinding
    private val viewModel: ProductListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentProductListBinding = FragmentProductListBinding.inflate(inflater)
        return fragmentProductListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun init() {
        setHasOptionsMenu(true)
        setTitle(R.string.title_home)
        fragmentProductListBinding.rvProductList.addItemDecoration(
            EqualSpacingItemDecoration(10, 10, 10, 10)
        )
        val adapter = ProductListAdapter()
        viewModel.liveDataProductList.observe(viewLifecycleOwner) { response ->
            response?.let {
                adapter.productList = it.products
                fragmentProductListBinding.rvProductList.adapter = adapter
            }
        }
        adapter.liveDataAddCartClick.observe(viewLifecycleOwner) {
            viewModel.insert(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.cart, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_cart -> {
                val action =
                    ProductListFragmentDirections.actionProductListFragmentToCartFragment2()
                findNavController().navigate(action)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}