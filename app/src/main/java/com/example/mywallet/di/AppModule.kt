package com.example.mywallet.di

import android.app.Application
import android.content.Context
import com.example.mywallet.data.remote.ApiInterface
import com.example.mywallet.data.repositoryImpl.DetailScreenRepositoryImpl
import com.example.mywallet.data.repositoryImpl.HomeScreenRepositoryImpl
import com.example.mywallet.domain.repository.detailsScreenRepo.DetailScreenRepository
import com.example.mywallet.domain.repository.homeScreenRepo.HomeScreenRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }


    @Singleton
    @Provides
    fun getHomeRepository(apiInterface: ApiInterface):HomeScreenRepository= HomeScreenRepositoryImpl(apiInterface)



    @Singleton
    @Provides
    fun getDetailScreenRepository(apiInterface: ApiInterface): DetailScreenRepository = DetailScreenRepositoryImpl(apiInterface)


}