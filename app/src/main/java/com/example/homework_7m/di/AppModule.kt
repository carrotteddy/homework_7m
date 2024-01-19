package com.example.homework_7m.di

import com.example.homework_7m.utils.Constants.API_KEY
import com.example.homework_7m.utils.Constants.BASE_URL
import com.example.homework_7m.utils.Constants.NETWORK_TIMEOUT
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBaseUrl(): String {
        return BASE_URL
    }

    @Provides
    @Singleton
    fun provideConnectionTimeout(): Long {
        return NETWORK_TIMEOUT
    }

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().setLenient().create()

    @Singleton
    @Provides
    fun provideOkHttpClient(baseUrl: String): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val requestInterceptor = Interceptor { chain ->
            val url = chain.request()
                .url
                .newBuilder()
                .addQueryParameter("api_key", API_KEY ?: "")
                .build()

            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            chain.proceed(request)
        }

        return OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

}