package com.plataformas.proyecto.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.plataformas.proyecto.R


class LogInFragment : Fragment(R.layout.fragment_log_in) {
private lateinit var btnLog:Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
            btnLog = findViewById(R.id.btnIniciar)
        }


        setListeners()
    }

    private fun setListeners() {
        btnLog.setOnClickListener {
            requireView().findNavController().navigate(LogInFragmentDirections.actionLogInFragmentToMuscleListFragment())
        }
    }


}