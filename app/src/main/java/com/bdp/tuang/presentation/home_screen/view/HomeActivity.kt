package com.bdp.tuang.presentation.home_screen.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bdp.tuang.R
import com.bdp.tuang.databinding.ActivityHomeBinding
//import com.bdp.tuang.presentation.Favorite_screen.view.FavoriteFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

//    private lateinit var confirmationDialogUtil: confirmationDialogUtil

//    private lateinit var sharePref: SharePrefHelper

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationFav -> {
                    replaceFragment(FavoriteFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationHome -> {
                    replaceFragment(DashboardFragment())
                    return@OnNavigationItemSelectedListener true
                }
//                R.id.navigationRandom -> {
//                    showConfirmation()
//                    return@OnNavigationItemSelectedListener false
//                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        sharePref = SharePrefHelper(this)
//        confirmationDialogUtil = ConfirmationDialogUtil(this)

        binding.bottomNavigation.setOnNavigationItemSelectedListener(
            onNavigationItemSelectedListener)

        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.navigationHome
        }

        replaceFragment(DashboardFragment())
    }

//    private fun showConfirmation(){
//        val title = "Makanan Rekomendasi Untuk Kamu Adalah"
//        val foodName = "Chicken Pee Taw"
//        confirmationDialogUtil.showConfirmationDialog(
//            title = title,
//            text = foodName,
//            onCancel = {
//
//            }
//        )
//    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}