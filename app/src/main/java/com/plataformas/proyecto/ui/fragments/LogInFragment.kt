package com.plataformas.proyecto.ui.fragments
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import com.plataformas.proyecto.R
import com.plataformas.proyecto.ui.fragments.LogInFragmentDirections


class LogInFragment : Fragment(R.layout.fragment_log_in) {
    private lateinit var btnLog:Button
    private lateinit var textViewRegistro : TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
            btnLog = findViewById(R.id.btnIniciar)
            textViewRegistro = findViewById(R.id.textViewRegistro)
        }


        setListeners()
    }

    private fun setListeners() {
        btnLog.setOnClickListener {
            requireView().findNavController().navigate(LogInFragmentDirections.actionLogInFragmentToMuscleListFragment())
        }
        textViewRegistro.setOnClickListener{
            requireView().findNavController().navigate(LogInFragmentDirections.actionLogInFragmentToRegisterFragment())
        }
    }


}