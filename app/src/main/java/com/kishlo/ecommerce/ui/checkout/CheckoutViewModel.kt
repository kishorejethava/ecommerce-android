package com.kishlo.ecommerce.ui.checkout

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kishlo.ecommerce.util.SingleLiveEvent

class CheckoutViewModel :
    ViewModel() {

    private val _liveDataContinueClick = SingleLiveEvent<Boolean>()
    val liveDataContinueClick: LiveData<Boolean> get() = _liveDataContinueClick

    fun onContinueShopping() {
        _liveDataContinueClick.postValue(true)
    }
}