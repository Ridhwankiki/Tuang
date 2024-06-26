package com.bdp.tuang.module

import com.bdp.tuang.data.TuangService
import com.bdp.tuang.data.remote.FoodCategoriesRemoteDatasource
import com.bdp.tuang.data.remote.FoodCategoriesRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FoodCategoriesModule {

    @Singleton
    @Provides
    fun provideMenuDashboardRemoteDatasource(service: TuangService):
            FoodCategoriesRemoteDatasource {
        return FoodCategoriesRemoteDatasourceImpl(service)
    }

}