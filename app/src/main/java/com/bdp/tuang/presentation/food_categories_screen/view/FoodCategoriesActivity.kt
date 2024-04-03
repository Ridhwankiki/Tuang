package com.bdp.tuang.presentation.food_categories_screen.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bdp.tuang.R
import com.bdp.tuang.databinding.ActivityFoodCategoriesBinding
import com.bdp.tuang.presentation.favorite_meals_screen.view.FavoriteMealsFragment
import com.bdp.tuang.presentation.recommended.view.RecommendedFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodCategoriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFoodCategoriesBinding

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationCategories -> {
                    replaceFragment(FoodCategoriesFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationFavorite -> {
                    replaceFragment(FavoriteMealsFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationRecommended-> {
                    replaceFragment(RecommendedFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnNavigationItemSelectedListener(
            onNavigationItemSelectedListener
        )
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}