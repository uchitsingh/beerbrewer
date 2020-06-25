package com.example.beerbrewer.beers.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beerbrewer.R
import com.example.beerbrewer.beers.data.model.Ingredients
import com.example.beerbrewer.beers.ui.adapter.BeerDetailAdapter
import kotlinx.android.synthetic.main.activity_beer_detail.*

class BeerDetailActivity : AppCompatActivity() {

    private lateinit var adapter: BeerDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beer_detail)

        val name = intent.getStringExtra(BeerActivity.BEER_NAME)
        val ingredients :Ingredients? = intent.getParcelableExtra(BeerActivity.BEER_INGREDENTS)
        setupBeerDetailView(name, ingredients)
    }

    private fun setupBeerDetailView(name: String?, ingredients: Ingredients?) {
        beer_detail_name.text = name

        beer_detail_rv.layoutManager = LinearLayoutManager(this)
        adapter = BeerDetailAdapter()
        adapter.setAdapter(ingredients)
        beer_detail_rv.adapter = adapter
    }

}