package com.kishlo.ecommerce.ui.productlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kishlo.ecommerce.data.repository.CartRepository
import com.kishlo.ecommerce.data.repository.ProductsListRepository
import com.kishlo.ecommerce.data.source.database.Cart
import com.kishlo.ecommerce.model.Product
import com.kishlo.ecommerce.model.ProductResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val productsListRepository: ProductsListRepository,
    private val cartRepository: CartRepository
) :
    ViewModel() {
    private val _liveDataProductList = MutableLiveData<ProductResponse>()
    val liveDataProductList: LiveData<ProductResponse> get() = _liveDataProductList

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            val products = productsListRepository.getProducts()
            _liveDataProductList.value = products
        }
    }

    fun insert(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            cartRepository.insert(product.run { Cart(image_url,name,price,rating) })
        }
    }
}