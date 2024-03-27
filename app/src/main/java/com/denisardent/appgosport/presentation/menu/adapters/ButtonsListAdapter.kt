package com.denisardent.appgosport.presentation.menu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.denisardent.appgosport.R
import com.denisardent.appgosport.databinding.ItemButtonBinding

class ButtonsListAdapter: ListAdapter<Pair<String, Boolean>, ButtonsListAdapter.ButtonViewHolder>(ItemCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemButtonBinding.inflate(inflater, parent, false)

        return ButtonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
        val buttonItem = getItem(position)

        with(holder.binding){
            button.text = buttonItem.first
            if (buttonItem.second == true){
                button.setTextColor(root.context.getColor(R.color.pink_primary))
                button.setBackgroundColor(root.context.getColor(R.color.light_pink))
            }
        }
    }

    class ButtonViewHolder(
        val binding: ItemButtonBinding
    ): RecyclerView.ViewHolder(binding.root)

    object ItemCallback: DiffUtil.ItemCallback<Pair<String, Boolean>>() {
        override fun areItemsTheSame(oldItem: Pair<String, Boolean>, newItem: Pair<String, Boolean>): Boolean {
            return oldItem.first == newItem.first
        }

        override fun areContentsTheSame(oldItem: Pair<String, Boolean>, newItem: Pair<String, Boolean>): Boolean {
            return oldItem == newItem
        }
    }
}