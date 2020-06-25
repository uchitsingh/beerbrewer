package com.example.beerbrewer.beers.ui.listener

import com.example.beerbrewer.beers.data.model.Ingredients

interface BeerClickListener {

    fun onClick(name: String?, ingredients: Ingredients?)

}