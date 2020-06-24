package com.example.beerbrewer.beers.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beerbrewer.R
import com.example.beerbrewer.beers.data.model.BeersResponseItem
import com.example.beerbrewer.beers.ui.viewholder.BeerViewHolder

class BeerAdapter : RecyclerView.Adapter<BeerViewHolder>() {
    private val beersResponse = mutableListOf<BeersResponseItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        return BeerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_beer,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return beersResponse.size
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        holder.bind(beersResponse[position])
    }

    fun setAdapter(beerResponseItem: List<BeersResponseItem>) {
        this.beersResponse.clear()
        this.beersResponse.addAll(beerResponseItem)
        notifyDataSetChanged()
    }
}