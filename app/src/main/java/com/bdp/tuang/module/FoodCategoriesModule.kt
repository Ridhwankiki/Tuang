package com.bdp.tuang.module

import com.bdp.tuang.data.TuangService
import com.bdp.tuang.data.remote.FoodCategoriesDataSource
import com.bdp.tuang.data.remote.FoodCategoriesDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FoodCategoriesModule {

    @Singleton
    @Provides

    fun provideFoodCategoriesRemoteDataSource(service: TuangService) : FoodCategoriesDataSource {
        return FoodCategoriesDataSourceImpl(service)
    }
}