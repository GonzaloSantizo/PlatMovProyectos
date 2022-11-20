package com.plataformas.proyecto.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import com.google.android.material.appbar.MaterialToolbar
import com.google.firebase.firestore.*
import com.plataformas.proyecto.R
import com.plataformas.proyecto.data.remote.firestore.ExercisesDto
import com.google.firebase.firestore.FirebaseFirestore
import com.plataformas.proyecto.ui.adapters.MuscleAdapter

class MuscleDetailsFragment : Fragment(R.layout.fragment_muscle_details) {

    private val args: MuscleDetailsFragmentArgs by navArgs()
    private lateinit var txtName : TextView
    private lateinit var txtMuscle : TextView
    private lateinit var txtDescription : TextView
    private lateinit var imgExercise : ImageView
    private lateinit var db: FirebaseFirestore
    private lateinit var btnBack: Button
    private lateinit var toolBar:MaterialToolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolBar = view.findViewById(R.id.toolbar_muscleDetails)
        txtMuscle = view.findViewById(R.id.txtView_muscleDetails_muscleName)
        txtName = view.findViewById(R.id.txtView_muscleDetails_exercise)
        txtDescription = view.findViewById(R.id.decription_details)
        imgExercise = view.findViewById(R.id.imageDetails)


        setToolbar()
        getCharacter()
    }

    private fun setToolbar() {
        val navController = findNavController()
        val appbarConfig = AppBarConfiguration(navController.graph)
        toolBar.setupWithNavController(navController, appbarConfig)
    }

    private fun getCharacter() {
        db = FirebaseFirestore.getInstance()
        db.collection("dbmuscles").document(
                args.name).get().addOnSuccessListener {
            if (it.exists()) {
                txtMuscle.text = it.data?.get("muscle").toString()
                txtDescription.text = it.data?.get("description").toString()
                txtName.text = it.data?.get("name").toString()
                imgExercise.load(it.data?.get("image")){
                    transformations(CircleCropTransformation())
                    memoryCachePolicy(CachePolicy.DISABLED)
                }
            } else {

            }
        }
    }
}