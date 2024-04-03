package com.bdp.tuang.presentation.favorite_meals_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bdp.tuang.data.response_model.Meals
import com.bdp.tuang.databinding.ItemFavoriteMealsBinding
import com.bumptech.glide.Glide

class FavoriteMealsAdapter (
    private val data:List<Meals>
): RecyclerView.Adapter<FavoriteMealsAdapter.FavoriteMealsViewHolder> () {


    inner class FavoriteMealsViewHolder(
        val binding: ItemFavoriteMealsBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(favoriteMeals: Meals){
            binding.root.context?.let {
                Glide
                    .with(it)
                    .load(favoriteMeals.strMealThumb)
                    .centerCrop()
                    .into(binding.ivFavoriteMeals)
            };
            binding.tvFavoriteMeals.text = favoriteMeals.strMeal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMealsViewHolder {
        return FavoriteMealsViewHolder(
            ItemFavoriteMealsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: FavoriteMealsViewHolder, position: Int) {
        holder.bind(data[position])

    }

}