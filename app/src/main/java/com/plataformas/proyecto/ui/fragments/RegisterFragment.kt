package com.plataformas.proyecto.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.plataformas.proyecto.R
import com.plataformas.proyecto.data.Resource
import com.plataformas.proyecto.data.remote.api.AuthApi
import com.plataformas.proyecto.data.repository.auth.AuthRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var btnRegister : Button
    private lateinit var inputEmailRegister : TextInputLayout
    private lateinit var inputPasswordRegister: TextInputLayout

    @Inject
    lateinit var authRepository: AuthRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
            btnRegister = findViewById(R.id.btnRegistrarse)
            inputEmailRegister = findViewById(R.id.emailRegister)
            inputPasswordRegister = findViewById(R.id.passwordRegister)

        }

        setListeners()
    }



    private fun setListeners() {
        btnRegister.setOnClickListener {
            val email = inputEmailRegister.editText!!.text.toString()
            val password = inputPasswordRegister.editText!!.text.toString()


            lifecycleScope.launch {
                val userId = authRepository.createUserWithEmailAndPassword(email,password)
                if (!userId.isNullOrEmpty()){
                    Toast.makeText(
                        context,
                        "User Created",
                        Toast.LENGTH_LONG).show()
                    requireView().findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLogInFragment())


                }
                else {
                    Toast.makeText(context,
                        "Usuario o contraseña incorrectos",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }



    }




}