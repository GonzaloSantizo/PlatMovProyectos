package com.plataformas.proyecto.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.*
import com.google.firebase.ktx.Firebase
import com.plataformas.proyecto.R
import com.plataformas.proyecto.data.remote.firestore.Exercises
import com.plataformas.proyecto.ui.adapters.MuscleAdapter



class MuscleListFragment : Fragment(R.layout.fragment_muscle_list), MuscleAdapter.RecyclerViewMuscleEvents {
    private lateinit var toolbar: MaterialToolbar
    private lateinit var recyclerMuscles:RecyclerView

    private lateinit var adapter: MuscleAdapter

    private lateinit var db : FirebaseFirestore
    private lateinit var auth : FirebaseAuth

//    val collectionReference : CollectionReference = db.collection("dbmuscles")


    private var exerciseList: ArrayList<Exercises> = arrayListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db= FirebaseFirestore.getInstance()
        auth= Firebase.auth


        view.apply {

            // Initializing components, see fragment_muscle_list
            toolbar = findViewById(R.id.toolbar_muscleList)
            recyclerMuscles = findViewById(R.id.recycler_muscles)
            setToolBar()
            setListeners()
            setupRecycler()
        }


    }

    /*
        Setting the toolbar to show the necessary data to the fragment
     */
    private fun setupRecycler() {

        recyclerMuscles.layoutManager = LinearLayoutManager(requireContext())
        recyclerMuscles.setHasFixedSize(true)

        adapter = MuscleAdapter(this.exerciseList, this)
        recyclerMuscles.adapter = adapter

    }


    private fun setToolBar(){
        val navController = findNavController()
        val appbarConfig = AppBarConfiguration(setOf(R.id.muscleListFragment))
        toolbar.setupWithNavController(navController, appbarConfig)
    }

    private fun setListeners() {
        toolbar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId) {
                R.id.menu_item_darkMode -> {
                    true
                }

                R.id.menu_item_logout -> {
                    //logout()
                    true

                }
                else -> true
            }
        }
    }


    override fun onItemClicked(exercises: Exercises) {
       val action = MuscleListFragmentDirections.actionMuscleListFragmentToMuscleDetailsFragment()
        requireView().findNavController().navigate(action)
    }




}





