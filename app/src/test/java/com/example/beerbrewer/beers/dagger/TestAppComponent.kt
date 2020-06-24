package com.example.beerbrewer.beers.dagger

import com.example.beerbrewer.beers.viewmodel.BeerViewModelTest
import com.example.beerbrewer.dagger.AppComponent
import com.example.beerbrewer.dagger.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, BeerModule::class])
interface TestAppComponent : AppComponent {

    fun inject(beerViewModelTest: BeerViewModelTest)

}
