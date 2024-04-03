package com.bdp.tuang.module

import com.bdp.tuang.data.TuangService
import com.bdp.tuang.data.remote.RecommendedRemoteDatasource
import com.bdp.tuang.data.remote.RecommendedRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RecommendedModule {

    @Singleton
    @Provides
    fun provideMenuDashboardRemoteDatasource(service: TuangService):
            RecommendedRemoteDatasource {
        return RecommendedRemoteDatasourceImpl(service)
    }

}