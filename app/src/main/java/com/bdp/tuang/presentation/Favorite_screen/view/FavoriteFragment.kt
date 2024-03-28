package com.bdp.tuang.presentation.Favorite_screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bdp.tuang.base.BaseFragment
import com.bdp.tuang.databinding.FragmentDashboardBinding
import com.bdp.tuang.databinding.FragmentFavoriteBinding

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {

    override fun inFlateBinding(
        inFlater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoriteBinding {
        return FragmentFavoriteBinding.inflate(inFlater, container, false)
    }

    override fun setupView() {
    }
}