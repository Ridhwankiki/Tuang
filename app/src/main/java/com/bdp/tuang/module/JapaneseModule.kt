package com.bdp.tuang.module

import com.bdp.tuang.data.TuangService
import com.bdp.tuang.data.remote.JapaneseRemoteDatasource
import com.bdp.tuang.data.remote.JapaneseRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object JapaneseModule {

    @Singleton
    @Provides
    fun provideMenuDashboardRemoteDatasource(service: TuangService):
            JapaneseRemoteDatasource {
        return JapaneseRemoteDatasourceImpl(service)
    }

}