package com.plataformas.proyecto.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.plataformas.proyecto.R


class MuscleDetailsFragment : Fragment(R.layout.fragment_muscle_details) {

    private lateinit var btnBack: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            btnBack = findViewById(R.id.btnBack)
        }

        setListeners()
    }

    private fun setListeners() {
        btnBack.setOnClickListener {
            requireView().findNavController().navigate(MuscleDetailsFragmentDirections.actionMuscleDetailsFragmentToMuscleListFragment())
        }
    }

}