package com.bdp.tuang.presentation.recommended.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bdp.tuang.base.BaseFragment
import com.bdp.tuang.data.response_model.Recommended
import com.bdp.tuang.databinding.FragmentRecommendedBinding
import com.bdp.tuang.presentation.recommended.adapter.RecommendedAdapter
import com.bdp.tuang.presentation.recommended.view_model.RecommendedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecommendedFragment : BaseFragment<FragmentRecommendedBinding>() {

    private val viewModel: RecommendedViewModel by viewModels()
    private lateinit var recommendedAdapter: RecommendedAdapter
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRecommendedBinding {
        return FragmentRecommendedBinding.inflate(inflater, container, false)
    }

    override fun setupView() {

        viewModel.getRecommended()
        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.recommended.observe(viewLifecycleOwner){
            setupViewRecommended(it.recommended)
        }
    }
    private fun setupViewRecommended(data: List<Recommended>){
        binding.componentRecommended.rvRecommended.adapter = RecommendedAdapter(data)
    }

}