package com.kishlo.ecommerce.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kishlo.ecommerce.data.repository.ProductsListRepository
import com.kishlo.ecommerce.model.ProductResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val repository: ProductsListRepository) :
    ViewModel() {
    private val _liveDataProductList = MutableLiveData<ProductResponse>()
    val liveDataProductList: LiveData<ProductResponse> get() = _liveDataProductList

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            val products = repository.getProducts()
            _liveDataProductList.value = products
        }
    }


}