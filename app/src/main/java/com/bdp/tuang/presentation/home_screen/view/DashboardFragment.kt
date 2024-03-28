package com.bdp.tuang.presentation.home_screen.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bdp.tuang.base.BaseFragment
import com.bdp.tuang.databinding.FragmentDashboardBinding
import com.bdp.tuang.presentation.home_screen.view_model.FoodCategoriesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private val viewModel: FoodCategoriesViewModel by viewModels()
    override fun inFlateBinding(
        inFlater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inFlater, container, false)
    }

    override fun setupView() {

        viewModel.getFoodCategories()
        viewModel.foodCategories.observe(viewLifecycleOwner) {it ->
            Log.d("Food Categories: ", it.toString())
        }
    }
}