package com.denisardent.appgosport.presentation.menu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.denisardent.appgosport.databinding.ItemBannerBinding

class BannerListAdapter: ListAdapter<Int, BannerListAdapter.BannerViewHolder>(ItemCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBannerBinding.inflate(inflater, parent, false)

        return BannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val bannerItem = getItem(position)

        with(holder.binding){
            bannerImage.setImageResource(bannerItem)
        }
    }

    class BannerViewHolder(
        val binding: ItemBannerBinding
    ): RecyclerView.ViewHolder(binding.root)

    object ItemCallback: DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }
    }
}