package com.example.beerbrewer.beers.data.remote

import com.example.beerbrewer.beers.data.model.BeersResponseItem
import com.example.beerbrewer.utils.Constants
import io.reactivex.Single
import retrofit2.http.GET

interface BeerService {

    @GET(Constants.BEERS_URL)
    fun fetchBeers(): Single<List<BeersResponseItem>>

}