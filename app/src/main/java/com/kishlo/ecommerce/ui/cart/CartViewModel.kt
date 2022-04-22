package com.kishlo.ecommerce.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kishlo.ecommerce.data.repository.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartRepository: CartRepository
) :
    ViewModel() {
    private val _liveDataCart = MutableLiveData<ArrayList<CartItem>>()
    val liveDataCart: LiveData<ArrayList<CartItem>> get() = _liveDataCart

    fun getCart() {
        viewModelScope.launch(Dispatchers.IO) {
            val cart = cartRepository.getCart()
            _liveDataCart.postValue(ArrayList(cart))
        }
    }
}