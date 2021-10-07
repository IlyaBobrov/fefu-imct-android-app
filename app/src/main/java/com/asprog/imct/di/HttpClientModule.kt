package com.asprog.imct.di

import com.asprog.imct.base.preferences.AppPreferences
import com.asprog.imct.urils.ConstantsApp.API_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

@Module
@InstallIn(SingletonComponent::class)
object HttpClientModule {

    @Provides
    fun provideOkHttpClient(preferences: AppPreferences): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor { message -> Timber.i(message) }.apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor {
                val original = it.request()
                val request = original.newBuilder().apply {
                    if (preferences.accessToken.isNotEmpty()) {
                        addHeader("Authorization", "Bearer ${preferences.accessToken}")
                    }
                }
                    .method(original.method, original.body)

                    .build()
                it.proceed(request)
            }
            .build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}