package com.kishlo.ecommerce.data.source.remote

import com.kishlo.ecommerce.model.ProductResponse
import retrofit2.http.GET

interface RetrofitService {

    @GET("nancymadan/assignment/db")
    suspend fun getProducts(): ProductResponse
}