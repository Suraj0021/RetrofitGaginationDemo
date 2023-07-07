package com.suraj.moviesdemo.di

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.suraj.moviesdemo.retrofit.MoviesApi
import com.suraj.moviesdemo.utils.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton


@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
//            .client(
//                OkHttpClient.Builder().addInterceptor(MoviesApi.loggingInterceptor)
//                    .build()
//            )
            .build()
    }

    @Singleton
    @Provides
    fun providesMoviesApi(retrofit: Retrofit): MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }
}