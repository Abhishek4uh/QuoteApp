package com.example.mywallet.di

import android.app.Application
import android.content.Context
import com.example.mywallet.data.remote.ApiInterface
import com.example.mywallet.data.remote.RemoteRepository
import com.example.mywallet.data.remote.RemoteRepositoryImpl
import com.example.mywallet.data.repositoryImpl.DetailScreenRepositoryImpl
import com.example.mywallet.data.repositoryImpl.HomeScreenRepositoryImpl
import com.example.mywallet.domain.repository.detailsScreenRepo.DetailScreenRepository
import com.example.mywallet.domain.repository.homeScreenRepo.HomeScreenRepository
import com.example.mywallet.presentation.resource.ErrorTypeToErrorTextConverter
import com.example.mywallet.presentation.resource.ErrorTypeToErrorTextConverterImpl
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

    @Provides
    @Singleton
    fun provideErrorTypeToErrorTextConverter(): ErrorTypeToErrorTextConverter {
        return ErrorTypeToErrorTextConverterImpl()
    }

    @Singleton
    @Provides
    fun provideRemoteRepository(service: ApiInterface): RemoteRepository = RemoteRepositoryImpl(service)


    @Singleton
    @Provides
    fun provideHomeScreenRepository(remoteRepository: RemoteRepository): HomeScreenRepository {
        return HomeScreenRepositoryImpl(remoteRepository)
    }

    @Singleton
    @Provides
    fun provideDetailScreenRepository(remoteRepository: RemoteRepository): DetailScreenRepository {
        return DetailScreenRepositoryImpl(remoteRepository)
    }

}