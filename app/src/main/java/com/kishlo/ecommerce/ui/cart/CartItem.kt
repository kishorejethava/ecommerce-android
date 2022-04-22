package com.kishlo.ecommerce.ui.cart

data class CartItem(
    var image_url: String?,
    var name: String?,
    var price: String?,
    var rating: Int? = 0
)