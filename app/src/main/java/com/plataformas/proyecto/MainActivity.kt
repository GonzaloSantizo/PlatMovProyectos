package com.plataformas.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import com.plataformas.proyecto.ui.fragments.ExercisesFragment
import com.plataformas.proyecto.ui.fragments.LogInFragment
import com.plataformas.proyecto.ui.fragments.MuscleListFragment
import com.plataformas.proyecto.ui.viewmodel.itemViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //private lateinit var bottomNav: BottomNavigationView
    private val viewModel : itemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}