package com.example.beerbrewer.beers.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beerbrewer.R
import com.example.beerbrewer.beers.data.model.BeersResponseItem
import com.example.beerbrewer.beers.ui.listener.BeerClickListener
import com.example.beerbrewer.beers.ui.viewholder.BeerViewHolder

class BeerAdapter(private val beerClickListener: BeerClickListener) :
    RecyclerView.Adapter<BeerViewHolder>() {

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
        holder.itemView.setOnClickListener {
            beerClickListener.onClick(
                beersResponse[position].name,
                beersResponse[position].ingredients
            )
        }
    }

    fun setAdapter(beerResponseItem: List<BeersResponseItem>) {
        this.beersResponse.clear()
        this.beersResponse.addAll(beerResponseItem)
        notifyDataSetChanged()
    }

}