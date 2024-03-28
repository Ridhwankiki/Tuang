package com.bdp.tuang.presentation.home_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bdp.tuang.data.response_model.Category
import com.bdp.tuang.databinding.ItemMenuDashboardBinding
import com.bumptech.glide.Glide

class DashboardAdapter (
    private val data:List<Category>
): RecyclerView.Adapter<DashboardAdapter.MainViewHolder> () {


    inner class MainViewHolder(
        val binding: ItemMenuDashboardBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(mainModel: Category){
            binding.root.context?.let {
                Glide
                    .with(it)
                    .load(mainModel.strCategoryThumb)
                    .centerCrop()
                    .into(binding.ivIkonMenu)
            };
            binding.tvMenu.text = mainModel.strCategory
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemMenuDashboardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(data[position])

    }

}