package com.kishlo.ecommerce.di

import com.kishlo.ecommerce.data.repository.ProductsListRepository
import com.kishlo.ecommerce.data.source.remote.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesProductsRepository(retrofitService: RetrofitService) : ProductsListRepository {
        return ProductsListRepository(retrofitService)
    }
}