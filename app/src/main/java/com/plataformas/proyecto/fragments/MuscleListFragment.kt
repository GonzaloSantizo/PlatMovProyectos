package com.plataformas.proyecto.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.plataformas.proyecto.R


class MuscleListFragment : Fragment(R.layout.fragment_muscle_list) {

private lateinit var btnToDetails : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    view.apply {
        btnToDetails = findViewById(R.id.btnList)
    }
        setListeners()
    }

    private fun setListeners() {
        btnToDetails.setOnClickListener {
            requireView().findNavController().navigate(MuscleListFragmentDirections.actionMuscleListFragmentToMuscleDetailsFragment())
        }
    }


}