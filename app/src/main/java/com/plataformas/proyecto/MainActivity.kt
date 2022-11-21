package com.plataformas.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
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