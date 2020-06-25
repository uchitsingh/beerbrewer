package com.example.beerbrewer.beers.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.beerbrewer.R
import com.example.beerbrewer.beers.data.model.Ingredients
import timber.log.Timber

class BeerDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beer_detail)

        val name = intent.getStringExtra(BeerActivity.BEER_NAME)
        val ingredients :Ingredients? = intent.getParcelableExtra(BeerActivity.BEER_INGREDENTS)

        Timber.d("ladongredients ${ingredients}, $name")
    }

}