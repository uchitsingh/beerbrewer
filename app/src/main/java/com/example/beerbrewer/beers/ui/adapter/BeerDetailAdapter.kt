package com.example.beerbrewer.beers.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.beerbrewer.R
import com.example.beerbrewer.beers.data.model.Hop
import com.example.beerbrewer.beers.data.model.Ingredients
import com.example.beerbrewer.beers.data.model.Malt
import com.example.beerbrewer.beers.ui.viewholder.HopsViewHolder
import com.example.beerbrewer.beers.ui.viewholder.MaltViewHolder
import com.example.beerbrewer.beers.ui.viewholder.YeastViewHolder
import kotlinx.android.synthetic.main.item_hops.view.*
import kotlinx.android.synthetic.main.item_malt.view.*
import kotlinx.android.synthetic.main.item_yeast.view.*

class BeerDetailAdapter : RecyclerView.Adapter<ViewHolder>() {

    private val items = mutableListOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val viewHolder: ViewHolder
        val inflater = LayoutInflater.from(parent.context)

        viewHolder = when (viewType) {
            ITEM_HOPS -> {
                val hopsView: View =
                    inflater.inflate(R.layout.item_hops, parent, false)
                HopsViewHolder(hopsView)
            }
            ITEM_MALT -> {
                val maltView: View =
                    inflater.inflate(R.layout.item_malt, parent, false)
                MaltViewHolder(maltView)
            }
            else -> {
                val yeastView: View =
                    inflater.inflate(R.layout.item_yeast, parent, false)
                YeastViewHolder(yeastView)
            }
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder.itemViewType) {
            ITEM_MALT -> {
                val maltViewHolder: MaltViewHolder = holder as MaltViewHolder
                configureMaltHolder(maltViewHolder, position)
            }
            ITEM_HOPS -> {
                val hopsViewHolder: HopsViewHolder = holder as HopsViewHolder
                configureHopsHolder(hopsViewHolder, position)
            }
            else -> {
                val yeastViewHolder: YeastViewHolder =
                    holder as YeastViewHolder
                configureYeastViewHolder(yeastViewHolder, position)
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when {
            items[position] is Malt -> {
                ITEM_MALT
            }
            items[position] is Hop -> {
                ITEM_HOPS
            }

            else -> {
                ITEM_YEAST
            }
        }
    }

    fun setAdapter(ingredients: Ingredients?) {
        this.items.clear()
        ingredients?.hops?.let { items.addAll(it) }
        ingredients?.malt?.let { items.addAll(it) }
        ingredients?.yeast?.let { items.addAll(listOf(it)) }
        notifyDataSetChanged()
    }

    private fun configureYeastViewHolder(yeastViewHolder: YeastViewHolder, position: Int) {
        val yeast = items[position] as String
        yeastViewHolder.itemView.yeast_name.text = yeast
    }

    private fun configureHopsHolder(hopsViewHolder: HopsViewHolder, position: Int) {
        val hop = items[position] as Hop
        hopsViewHolder.itemView.hops_add_value.text = hop.add
        hopsViewHolder.itemView.hops_attribute_value.text = hop.attribute
        hopsViewHolder.itemView.hops_name_value.text = hop.name
        hopsViewHolder.itemView.hops_unit_value.text = hop.amount?.unit
        hopsViewHolder.itemView.hops_value_value.text = hop.amount?.value.toString()
    }

    private fun configureMaltHolder(maltViewHolder: MaltViewHolder, position: Int) {
        val malt = items[position] as Malt
        maltViewHolder.itemView.malt_name_value.text = malt.name
        maltViewHolder.itemView.malt_unit_value.text = malt.amount?.unit
        maltViewHolder.itemView.malt_value_value.text = malt.amount?.value.toString()
    }

    companion object {
        const val ITEM_HOPS: Int = 0
        const val ITEM_MALT: Int = 1
        const val ITEM_YEAST: Int = 2

    }

}
