package com.kishlo.ecommerce.data.source.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kishlo.ecommerce.ui.cart.CartItem

@Dao
interface CartDao {
    @Query("SELECT * FROM cart")
    fun getCart(): List<CartItem>

    @Insert
    fun insert(cart: Cart)
}