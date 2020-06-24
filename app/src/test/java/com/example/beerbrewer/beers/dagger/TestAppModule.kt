package com.example.beerbrewer.beers.dagger

import com.example.beerbrewer.dagger.AppModule
import com.squareup.moshi.Moshi
import io.mockk.mockk
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class TestAppModule : AppModule() {

    override fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit = mockk()

    override fun provideMoshi(): Moshi = mockk()

    override fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = mockk()

    override fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = mockk()

}