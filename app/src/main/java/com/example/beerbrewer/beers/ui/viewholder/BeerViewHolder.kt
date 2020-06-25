package com.example.beerbrewer.beers.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.beerbrewer.beers.data.model.BeersResponseItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_beer.view.*

class BeerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(beersResponseItem: BeersResponseItem) {
        beersResponseItem.let {
            itemView.item_beer_name.text = it.name
            itemView.item_beer_description.text = it.description
            Picasso.get().load(it.imageUrl).into(itemView.item_beer_image)
        }
    }

}
