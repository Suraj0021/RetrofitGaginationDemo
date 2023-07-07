package com.suraj.moviesdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.suraj.moviesdemo.R
import com.suraj.moviesdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_LABELED

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_nowPlaying -> {
                    navController.popBackStack()
                    navController.navigate(R.id.playingFragment)
                    true
                }

                R.id.navigation_topRated -> {
                    navController.popBackStack()
                    navController.navigate(R.id.topRatedFragment)
                    true
                }

                R.id.navigation_populer -> {
                    navController.popBackStack()
                    navController.navigate(R.id.populerFragment)
                    true
                }

                R.id.navigation_upcoming -> {
                    navController.popBackStack()
                    navController.navigate(R.id.upcomingFragment)
                    true
                }

                else -> false
            }
        }

    }
}