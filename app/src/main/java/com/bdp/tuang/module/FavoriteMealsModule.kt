package com.bdp.tuang.module

import com.bdp.tuang.data.TuangService
import com.bdp.tuang.data.remote.FavoriteMealsRemoteDatasource
import com.bdp.tuang.data.remote.FavoriteMealsRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FavoriteMealsModule {

    @Singleton
    @Provides
    fun provideMenuDashboardRemoteDatasource(service: TuangService):
            FavoriteMealsRemoteDatasource {
        return FavoriteMealsRemoteDatasourceImpl(service)
    }

}