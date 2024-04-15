package com.example.basedroidxml.di

import android.app.Application
import com.example.basedroidxml.network.APIService
import com.example.basedroidxml.network.NetworkConnectionInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesApiService(
        url: String,
        networkConnectionInterceptor: NetworkConnectionInterceptor
    ): APIService {

        val cacheSize = (5 * 1024 * 1024).toLong()
        val myCache = Cache(networkConnectionInterceptor.applicationContext.cacheDir, cacheSize)
        val okkHttpclient = OkHttpClient.Builder().cache(myCache)
            .addInterceptor(networkConnectionInterceptor)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(okkHttpclient)
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }

    @Singleton
    @Provides
    fun provideNetworkInterceptors(app: Application): NetworkConnectionInterceptor {
        return NetworkConnectionInterceptor(app)
    }

    @Provides
    fun provideBaseUrl(): String {
        return "https://your-api-base-url.com" // Replace with your API base URL
    }

}