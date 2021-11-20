package com.elieomatuku.compositepatternarticle.leaf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.elieomatuku.compositepatternarticle.R
import com.elieomatuku.domain.other_entities.Asset


/**
 * Created by elieomatuku on 2021-11-19
 */

class AssetAdapter(private val assets: List<Asset>) :
    RecyclerView.Adapter<AssetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetViewHolder {
        return AssetViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: AssetViewHolder, position: Int) {
        val asset = assets[position]
        holder.update(asset)
    }

    override fun getItemCount(): Int {
        return assets.size
    }

}

class AssetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        private fun createView(parent: ViewGroup): View {
            return LayoutInflater.from(parent.context)
                .inflate(R.layout.viewholder_asset, parent, false)
        }

        fun newInstance(parent: ViewGroup): AssetViewHolder {
            return AssetViewHolder(createView(parent))
        }
    }

    fun update(asset: Asset) {
        itemView.findViewById<TextView>(R.id.asset_view).text = "${asset.name} : ZAR ${asset.value}"
    }
}