package com.example.beerbrewer.beers.dagger

import com.example.beerbrewer.beers.data.remote.BeerService
import com.example.beerbrewer.beers.data.repository.BeerRepository
import com.example.beerbrewer.beers.data.repository.BeerRepositoryImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
open class BeerModule {

    @Provides
    @Singleton
    open fun provideBeerRepository(beerService: BeerService): BeerRepository =
        BeerRepositoryImpl(beerService)

    @Provides
    @Singleton
    open fun provideBeerService(retrofit: Retrofit): BeerService =
        retrofit.create(BeerService::class.java)

}