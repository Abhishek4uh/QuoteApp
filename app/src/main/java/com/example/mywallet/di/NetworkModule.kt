package com.example.mywallet.di

import android.content.Context
import android.util.Log
import androidx.viewbinding.BuildConfig
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.mywallet.data.remote.ApiInterface
import com.example.mywallet.common.AppConstants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{



    @Provides
    @Singleton
    fun provideChuckerInterceptor(context: Context): ChuckerInterceptor {
        return ChuckerInterceptor.Builder(context).alwaysReadResponseBody(true).build()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }


    @Provides
    @Singleton
    fun provideOkhttpClient(mHttpLoggingInterceptor: HttpLoggingInterceptor,chuckerInterceptor:ChuckerInterceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            //Debug Build... you will see Logs and chucks as well
            builder.addInterceptor(mHttpLoggingInterceptor)
            builder.addInterceptor(chuckerInterceptor)
            Log.d("NETWORK", "Debug OkHttpClient created")
        }
        else {
            //Release Build... you won't see any Logs
            Log.d("NETWORK", "Release OkHttpClient created")
        }
        return builder.build()

    }

    @Provides
    @Singleton
    fun gsonConvertorFactory(): GsonConverterFactory = GsonConverterFactory.create()



    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL).client(client)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun getApiClient(retrofit: Retrofit):ApiInterface = retrofit.create(ApiInterface::class.java)

}