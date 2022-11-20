package com.plataformas.proyecto.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import com.google.android.material.appbar.MaterialToolbar
import com.plataformas.proyecto.R


class MuscleDetailsFragment : Fragment(R.layout.fragment_muscle_details) {

    private val args: MuscleDetailsFragmentArgs by navArgs()
    private lateinit var txtName : TextView
    private lateinit var txtMuscle : TextView
    private lateinit var txtDescription : TextView
    private lateinit var imgExercise : ImageView

    private lateinit var btnBack: Button
    private lateinit var toolBar:MaterialToolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            toolBar = findViewById(R.id.toolbar_muscleDetails)
            txtMuscle = findViewById(R.id.txtView_muscleDetails_muscleName)
            txtName = findViewById(R.id.txtView_Adapter_exercise_name)
            txtDescription = findViewById(R.id.decription_details)
            imgExercise = findViewById(R.id.imageDetails)
        }
        val args = this.arguments
        val muscle = args?.get("muscle")
        val exercise = args?.get("exercise")
        val description = args?.get("description")
        val image = args?.get("image")
        txtMuscle.text = muscle.toString()
        txtName.text = exercise.toString()
        txtDescription.text = description.toString()
        imgExercise.load(image){
            transformations(CircleCropTransformation())
            memoryCachePolicy(CachePolicy.DISABLED)
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
    btnBack.setOnClickListener {
            requireView().findNavController().navigate(MuscleDetailsFragmentDirections.actionMuscleDetailsFragmentToMuscleListFragment())
        }
    }

}