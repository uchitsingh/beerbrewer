package com.example.beerbrewer.beers.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.beerbrewer.beers.data.model.BeersResponseItem
import com.example.beerbrewer.beers.data.repository.BeerRepository
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

class BeerViewModel(private val repository: BeerRepository) : ViewModel() {

    private val disposable = CompositeDisposable()

    private val _beerObservable: MutableLiveData<List<BeersResponseItem>> = MutableLiveData()
    val beerObservable: LiveData<List<BeersResponseItem>>
        get() = _beerObservable

    fun fetchBeers() {
        Timber.d("Fetch Beers Response Started")

        disposable.add(repository.fetchBeers().subscribe(
            {
                Timber.d("Beer response success, $it")
                _beerObservable.value = it
            }, {
                Timber.e("Beer response Error, ${it.message}")
            }
        ))
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}