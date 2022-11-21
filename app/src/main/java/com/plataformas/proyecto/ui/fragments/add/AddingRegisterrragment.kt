package com.plataformas.proyecto.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.plataformas.proyecto.R
import com.plataformas.proyecto.data.model.RegisterData
import com.plataformas.proyecto.ui.viewmodel.RegisterViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [AddingRegisterragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddingRegisterragment : Fragment(R.layout.fragment_adding_register_fragment) {
    // TODO: Rename and change types of parameters
    private lateinit var mRegisterViewModel : RegisterViewModel
    private lateinit var exerciseNameTxt : EditText
    private lateinit var descriptionTxt : EditText
    private lateinit var weightTxt: EditText
    private lateinit var savebtn : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exerciseNameTxt = view.findViewById(R.id.editText_fragment_exerciseName)
        descriptionTxt = view.findViewById(R.id.editTextTextMultiLine_fragment_description)
        weightTxt = view.findViewById(R.id.editText_fragment_amountWeigth)
        mRegisterViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        savebtn = view.findViewById(R.id.btn_saveData_fragment)
        insertDataToDataBase()
        setListener()
    }

    private fun setListener() {
        savebtn.setOnClickListener{
            insertDataToDataBase()
        }
    }

    private fun insertDataToDataBase(){
        val exerciseName = exerciseNameTxt.text.toString()
        val description = descriptionTxt.text.toString()
        val weight = weightTxt.text!!

        if(inputCheck(exerciseName,description, weight)){
            val register = RegisterData(0, exerciseName, description,Integer.parseInt(weight.toString()))
            mRegisterViewModel.addRegister(register)
            Toast.makeText(requireContext(),"Succesfully added!", Toast.LENGTH_LONG).show()
            requireView().findNavController().navigate(AddingRegisterragmentDirections.actionAddingRegisterragmentToExercisesFragment())
        }else{
            Toast.makeText(requireContext(),"Please, fill out all fields.!", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(exerciseName : String, description : String, weight : Editable) : Boolean{
        return !(TextUtils.isEmpty(exerciseName) && TextUtils.isEmpty(description) && weight.isEmpty())
    }
}