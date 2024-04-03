package com.bdp.tuang.presentation.food_categories_screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bdp.tuang.base.BaseFragment
import com.bdp.tuang.data.response_model.Categories
import com.bdp.tuang.databinding.FragmentFoodCategoriesBinding
import com.bdp.tuang.presentation.food_categories_screen.adapter.FoodCategoriesAdapter
import com.bdp.tuang.presentation.food_categories_screen.view_model.FoodCategoriesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodCategoriesFragment : BaseFragment<FragmentFoodCategoriesBinding>() {

    private val viewModel: FoodCategoriesViewModel by viewModels()
    private lateinit var foodCategoriesAdapter: FoodCategoriesAdapter
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFoodCategoriesBinding {
        return FragmentFoodCategoriesBinding.inflate(inflater, container, false)
    }

    override fun setupView() {

        viewModel.getFoodCategories()
        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.foodCategories.observe(viewLifecycleOwner){
            setupViewFoodCategories(it.categories)
        }
    }
    private fun setupViewFoodCategories(data: List<Categories>){
        binding.componentAllCategoriesHome.gridMenu.adapter = FoodCategoriesAdapter(data)
    }

}

