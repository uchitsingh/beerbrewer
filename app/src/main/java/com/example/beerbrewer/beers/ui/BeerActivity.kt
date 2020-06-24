package com.example.beerbrewer.beers.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beerbrewer.App
import com.example.beerbrewer.R
import com.example.beerbrewer.beers.data.repository.BeerRepository
import com.example.beerbrewer.beers.ui.adapter.BeerAdapter
import com.example.beerbrewer.beers.viewmodel.BeerViewModel
import com.example.beerbrewer.beers.viewmodel.BeerViewModelFactory
import kotlinx.android.synthetic.main.activity_beer.*
import javax.inject.Inject

class BeerActivity : AppCompatActivity() {

    private lateinit var viewModel: BeerViewModel

    @Inject
    lateinit var repository: BeerRepository

    private lateinit var adapter: BeerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beer)
        (applicationContext as App).appComponent.inject(this)
        setupRecyclerView()
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel =
            ViewModelProvider(this, BeerViewModelFactory(repository)).get(BeerViewModel::class.java)
        viewModel.fetchBeers()
        viewModel.beerObservable.observe(this, Observer {
            adapter.setAdapter(it)
        })
    }

    private fun setupRecyclerView(){
        beer_rv.layoutManager = LinearLayoutManager(this)
        adapter = BeerAdapter()
        beer_rv.adapter = adapter
    }

}