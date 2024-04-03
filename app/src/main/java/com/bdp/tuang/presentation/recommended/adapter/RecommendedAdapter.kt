package com.bdp.tuang.presentation.recommended.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bdp.tuang.data.response_model.Recommended
import com.bdp.tuang.databinding.ItemRecommendedBinding
import com.bumptech.glide.Glide

class RecommendedAdapter (
    private val data:List<Recommended>
): RecyclerView.Adapter<RecommendedAdapter.RecommendedViewHolder> () {


    inner class RecommendedViewHolder(
        val binding: ItemRecommendedBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(recommendedModel: Recommended){
            binding.root.context?.let {
                Glide
                    .with(it)
                    .load(recommendedModel.strMealThumb)
                    .centerCrop()
                    .into(binding.ivRecommended)
            };
            binding.tvRecommended.text = recommendedModel.strMeal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedViewHolder {
        return RecommendedViewHolder(
            ItemRecommendedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecommendedViewHolder, position: Int) {
        holder.bind(data[position])

    }

}