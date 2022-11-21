package com.plataformas.proyecto.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.google.android.material.textfield.TextInputLayout
import com.plataformas.proyecto.R
import com.plataformas.proyecto.data.repository.auth.AuthRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LogInFragment : Fragment(R.layout.fragment_log_in) {
    private lateinit var btnLog:Button
    private lateinit var textViewRegistro : TextView
    private lateinit var inputEmail: TextInputLayout
    private lateinit var inputPassword : TextInputLayout

    @Inject
    lateinit var authRepository: AuthRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
            btnLog = findViewById(R.id.btnIniciar)
            textViewRegistro = findViewById(R.id.textViewRegistro)
            inputEmail = findViewById(R.id.inputEmail_layout)
            inputPassword= findViewById(R.id.inputPassword_layout)
        }
        setListeners()
    }

    private fun setListeners() {
        btnLog.setOnClickListener {
            val email = inputEmail.editText!!.text.toString()
            val password = inputPassword.editText!!.text.toString()

            lifecycleScope.launch {
                val userId = authRepository.signInWithEmailAndPassword(email,password)
                if (!userId.isNullOrEmpty()){
                    Toast.makeText(
                        context,
                        "Log In exitoso",
                        Toast.LENGTH_LONG).show()
                    requireView().findNavController().navigate(LogInFragmentDirections.actionLogInFragmentToMuscleListFragment())
                }
                else {
                    Toast.makeText(context,
                    "Usuario o contraseña incorrectos",
                        Toast.LENGTH_LONG
                        ).show()
                }
            }
        }
        textViewRegistro.setOnClickListener{
            requireView().findNavController().navigate(LogInFragmentDirections.actionLogInFragmentToRegisterFragment())
        }
    }
}