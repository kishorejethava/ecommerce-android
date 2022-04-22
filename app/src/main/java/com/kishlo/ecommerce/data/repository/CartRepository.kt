package com.kishlo.ecommerce.data.repository

import com.kishlo.ecommerce.data.source.database.Cart
import com.kishlo.ecommerce.data.source.database.CartDao
import com.kishlo.ecommerce.ui.cart.CartItem
import javax.inject.Inject

class CartRepository @Inject constructor(private val cartDao: CartDao) {
    fun insert(cart: Cart)  =  cartDao.insert(cart)
    fun getCart() : List<CartItem> =  cartDao.getCart()
}