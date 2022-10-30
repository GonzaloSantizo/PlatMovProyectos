package com.plataformas.proyecto.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.plataformas.proyecto.R


class MuscleDetailsFragment : Fragment(R.layout.fragment_muscle_details) {

    private lateinit var btnBack: Button
    private lateinit var toolBar:MaterialToolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            toolBar = findViewById(R.id.toolbar_muscleDetails)
        }
        setToolbar()
        setListeners()
    }

    private fun setToolbar() {
        val navController = findNavController()
        val appbarConfig = AppBarConfiguration(navController.graph)
        toolBar.setupWithNavController(navController, appbarConfig)
    }

    private fun setListeners() {
//        btnBack.setOnClickListener {
//            requireView().findNavController().navigate(MuscleDetailsFragmentDirections.actionMuscleDetailsFragmentToMuscleListFragment())
//        }
    }

}