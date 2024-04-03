package com.bdp.tuang.presentation.food_categories_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bdp.tuang.data.response_model.Categories
import com.bdp.tuang.databinding.ItemFoodCategoriesBinding
import com.bumptech.glide.Glide

class FoodCategoriesAdapter (
    private val data:List<Categories>
): RecyclerView.Adapter<FoodCategoriesAdapter.FoodCategoriesViewHolder> () {


    inner class FoodCategoriesViewHolder(
        val binding: ItemFoodCategoriesBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(foodCategoriesModel: Categories){
            binding.root.context?.let {
                Glide
                    .with(it)
                    .load(foodCategoriesModel.strCategoryThumb)
                    .centerCrop()
                    .into(binding.ivhome)
            };
            binding.tvhome.text = foodCategoriesModel.strCategory
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodCategoriesViewHolder {
        return FoodCategoriesViewHolder(
            ItemFoodCategoriesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: FoodCategoriesViewHolder, position: Int) {
        holder.bind(data[position])

    }

}