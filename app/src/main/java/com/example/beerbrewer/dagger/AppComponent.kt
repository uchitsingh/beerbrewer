package com.example.beerbrewer.dagger

import com.example.beerbrewer.beers.dagger.BeerModule
import com.example.beerbrewer.beers.ui.activity.BeerActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, BeerModule::class])
interface AppComponent {

    fun inject(beerActivity: BeerActivity)

}