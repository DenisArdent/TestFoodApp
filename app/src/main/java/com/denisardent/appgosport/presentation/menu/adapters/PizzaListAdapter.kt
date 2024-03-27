package com.denisardent.appgosport.presentation.menu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.denisardent.appgosport.R
import com.denisardent.appgosport.entites.PizzaData
import com.denisardent.appgosport.databinding.ItemPizzaBinding

class PizzaListAdapter: ListAdapter<PizzaData, PizzaListAdapter.PizzaViewHolder>(ItemCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPizzaBinding.inflate(inflater, parent, false)

        return PizzaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val pizzaItem = getItem(position)

        with(holder.binding){
            Glide
                .with(root)
                .load(pizzaItem.image)
                .into(pizzaImage)
            pizzaTitle.text = pizzaItem.name
            pizzaIngredients.text = pizzaItem.ingredients
            buyButton.text = root.context.getString(R.string.pizza_cost, pizzaItem.price.toString())
        }
    }

    class PizzaViewHolder(
        val binding: ItemPizzaBinding
    ): RecyclerView.ViewHolder(binding.root)

    object ItemCallback: DiffUtil.ItemCallback<PizzaData>() {
        override fun areItemsTheSame(oldItem: PizzaData, newItem: PizzaData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PizzaData, newItem: PizzaData): Boolean {
            return oldItem == newItem
        }
    }
}