package com.example.beerbrewer.beers.viewmodel.dagger

import com.example.beerbrewer.beers.dagger.BeerModule
import com.example.beerbrewer.beers.data.remote.BeerService
import com.example.beerbrewer.beers.data.repository.BeerRepository
import io.mockk.mockk
import retrofit2.Retrofit

class TestBeerModule : BeerModule() {

    override fun provideBeerRepository(beerService: BeerService): BeerRepository = mockk()

    override fun provideBeerService(retrofit: Retrofit): BeerService = mockk()

}