package com.plataformas.proyecto.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.plataformas.proyecto.R

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var btnRegister : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
            btnRegister = findViewById(R.id.btnRegistrarse)
        }

        setListeners()
    }


    private fun setListeners() {
        btnRegister.setOnClickListener {
            requireView().findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLogInFragment())
        }
    }


}