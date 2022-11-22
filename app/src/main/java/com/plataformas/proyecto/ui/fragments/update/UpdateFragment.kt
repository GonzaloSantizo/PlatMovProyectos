package com.plataformas.proyecto.ui.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.plataformas.proyecto.R
import com.plataformas.proyecto.data.model.RegisterData
import com.plataformas.proyecto.ui.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import org.w3c.dom.Text

class UpdateFragment : Fragment(R.layout.fragment_update) {
    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var inputExercise : EditText
    private lateinit var inputDescription : EditText
    private lateinit var inputWeight : EditText
    private lateinit var toolbar: MaterialToolbar
    private lateinit var btnUpdate : Button
    private lateinit var mRegisterViewModel: RegisterViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mRegisterViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        toolbar = view.findViewById(R.id.toolbar_fragment_updateData)
        inputExercise = view.findViewById(R.id.editText_fragment_updateExerciseName)
        inputDescription = view.findViewById(R.id.editTextTextMultiLine_fragment_updateDescription)
        inputWeight = view.findViewById(R.id.editText_fragment_updateAmountWeigth)
        btnUpdate = view.findViewById(R.id.btn_updateData_fragment)
        setToolbar()
        setListeners()
    }

    private fun setToolbar(){
        val navController = findNavController()
        val appbarConfig = AppBarConfiguration(setOf(R.id.exercisesFragment))
        toolbar.setupWithNavController(navController, appbarConfig)
    }

    private fun setListeners(){
        inputExercise.setText(args.currentRegister.exercise)
        inputDescription.setText(args.currentRegister.description)
        inputWeight.setText(args.currentRegister.weight.toString())

        btnUpdate.setOnClickListener{
            updateItem()
        }

        toolbar.setOnMenuItemClickListener{ menuItem ->
            when(menuItem.itemId){
                R.id.menu_item_delete ->{
                    delete()
                    true
                }
            }
            true

        }
    }

    private fun updateItem(){
        val exercise = inputExercise.text.toString()
        val description = inputDescription.text.toString()
        val weight = Integer.parseInt(inputWeight.text.toString())

        if(inputCheck(exercise,description, inputWeight.text)){
            // Create user object
            val updateRegister = RegisterData(args.currentRegister.id, exercise, description, weight)
            // update current user
            mRegisterViewModel.updateRegister(updateRegister)
            // Navigate Back
            Toast.makeText(requireContext(),"Updated succesfully!", Toast.LENGTH_LONG).show()
            requireView().findNavController().navigate(UpdateFragmentDirections.actionUpdateFragmentToExercisesFragment())
        }else{
            Toast.makeText(requireContext(),"Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    /**
     * Verify if a field it's empty
     */
    private fun inputCheck(exerciseName : String, description : String, weight : Editable) : Boolean{
        return !(TextUtils.isEmpty(exerciseName) && TextUtils.isEmpty(description) && weight.isEmpty())
    }

    private fun delete(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Si"){ _,_->
            mRegisterViewModel.deleteRegister(args.currentRegister)
            Toast.makeText(requireContext(), "Se elimino exitosamente el registro: ${args.currentRegister.exercise}",Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton("No"){ _,_,->}
        builder.setTitle("¿Eliminar ${args.currentRegister.exercise}?")
        builder.setMessage("¿Esta seguro que desea eliminar ${args.currentRegister.exercise}?")
        builder.create().show()
    }
}