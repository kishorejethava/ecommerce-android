package com.kishlo.ecommerce.data.repository

import com.kishlo.ecommerce.data.source.remote.RetrofitService
import com.kishlo.ecommerce.model.ProductResponse
import javax.inject.Inject

class ProductsListRepository @Inject constructor(private val service: RetrofitService) {
    suspend fun getProducts() : ProductResponse =  service.getProducts()
}