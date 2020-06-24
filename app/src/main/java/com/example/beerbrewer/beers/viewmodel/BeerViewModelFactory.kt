package com.example.beerbrewer.beers.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.beerbrewer.beers.data.repository.BeerRepository

@Suppress("UNCHECKED_CAST")
class BeerViewModelFactory(private var repository: BeerRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BeerViewModel(repository) as T
    }
}