package com.kishlo.ecommerce.ui.cart

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kishlo.ecommerce.R
import com.kishlo.ecommerce.data.repository.CartRepository
import com.kishlo.ecommerce.util.SingleLiveEvent
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

    private val _liveDataCheckoutClick = SingleLiveEvent<Boolean>()
    val liveDataCheckoutClick: LiveData<Boolean> get() = _liveDataCheckoutClick

    fun getCart() {
        viewModelScope.launch(Dispatchers.IO) {
            val cart = cartRepository.getCart()
            _liveDataCart.postValue(ArrayList(cart))
        }
    }

    fun onCheckout() {
        _liveDataCheckoutClick.postValue(true)
    }
}