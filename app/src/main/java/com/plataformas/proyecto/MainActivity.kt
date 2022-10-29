package com.plataformas.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    private lateinit var toolBarName : MaterialToolbar
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Setting AppBar
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.fragmentContainer
        )as NavHostFragment

        navController = navHostFragment.navController

        val appBarConfig = AppBarConfiguration(navController.graph)
        toolBarName = findViewById(R.id.toolbar_mainActivity)
        toolBarName.setupWithNavController(navController, appBarConfig)
        listenToNavGraphChanges()
    }

    private fun listenToNavGraphChanges(){
        navController.addOnDestinationChangedListener(NavController.OnDestinationChangedListener { _, destination, _ ->
            // Showing the corresponding menu for each fragment
            when (destination.id) {

                R.id.logInFragment -> {
                    toolBarName.visibility = View.INVISIBLE
                    toolBarName.menu.findItem(R.id.menu_darkMode).isVisible = true
                    toolBarName.menu.findItem(R.id. menu_closeSession).isVisible = true
                }
                R.id.muscleListFragment->{
                    toolBarName.visibility = View.VISIBLE
                    
                    toolBarName.menu.findItem(R.id.menu_darkMode).isVisible = true
                    toolBarName.menu.findItem(R.id.menu_darkMode).isVisible = true
                }
                R.id.muscleDetailsFragment->{
                    toolBarName.visibility = View.VISIBLE
                    toolBarName.menu.findItem(R.id.menu_darkMode).isVisible = true
                    toolBarName.menu.findItem(R.id.menu_darkMode).isVisible = true
                }
                else -> false
            }
        })
    }
}