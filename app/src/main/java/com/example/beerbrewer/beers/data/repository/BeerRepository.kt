package com.example.beerbrewer.beers.data.repository

import com.example.beerbrewer.beers.data.model.BeersResponseItem
import io.reactivex.Single

interface BeerRepository {

    fun fetchBeers(): Single<List<BeersResponseItem>>

}