package com.kishlo.ecommerce.model

data class Product(
    var image_url: String?,
    var name: String?,
    var price: String?,
    var rating: Int? = 0
)