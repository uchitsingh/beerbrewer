package com.example.beerbrewer

import android.app.Application
import com.example.beerbrewer.dagger.AppComponent
import com.example.beerbrewer.dagger.AppModule
import com.example.beerbrewer.dagger.DaggerAppComponent
import timber.log.Timber

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger()
        Timber.plant(Timber.DebugTree())
    }

    private fun initDagger(): AppComponent =
        DaggerAppComponent.builder().appModule(AppModule())
            .build()

}