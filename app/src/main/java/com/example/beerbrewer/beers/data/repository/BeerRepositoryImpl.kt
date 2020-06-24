package com.example.beerbrewer.beers.data.repository

import com.example.beerbrewer.beers.data.model.BeersResponseItem
import com.example.beerbrewer.beers.data.remote.BeerService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class BeerRepositoryImpl(private val beerService: BeerService) : BeerRepository {

    override fun fetchBeers(): Single<List<BeersResponseItem>> = beerService.fetchBeers()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnSuccess {
            Timber.d("Beers response success from API: ${it}")
        }

}