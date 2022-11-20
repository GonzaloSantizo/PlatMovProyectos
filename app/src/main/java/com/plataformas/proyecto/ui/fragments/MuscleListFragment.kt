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
import com.plataformas.proyecto.R
import com.plataformas.proyecto.data.remote.firestore.Exercises
import com.plataformas.proyecto.ui.adapters.MuscleAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MuscleListFragment : Fragment(R.layout.fragment_muscle_list), MuscleAdapter.RecyclerViewMuscleEvents {
    private lateinit var toolbar: MaterialToolbar
    private lateinit var recyclerMuscles:RecyclerView
    private lateinit var adapter: MuscleAdapter

    private val exercises: MutableList<Exercises> = mutableListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
        }
        // Initializing components, see fragment_muscle_list
        toolbar = view.findViewById(R.id.toolbar_muscleList)
        recyclerMuscles = view.findViewById(R.id.recycler_muscles)
        setToolBar()
        setListeners()
        setupRecycler()
    }

    /*
        Setting the toolbar to show the necessary data to the fragment
     */
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
                    logout()
                    true

                }
                else -> true
            }
        }
    }
    private fun setupRecycler() {
        adapter = MuscleAdapter(this.exercises, this)
        recyclerMuscles.layoutManager = LinearLayoutManager(requireContext())
        recyclerMuscles.setHasFixedSize(true)
        recyclerMuscles.adapter = adapter
    }

    override fun onItemClicked(exercises: Exercises) {
       val action = MuscleListFragmentDirections.actionMuscleListFragmentToMuscleDetailsFragment()
        requireView().findNavController().navigate(action)
    }

    private fun logout() {
        CoroutineScope(Dispatchers.IO).launch {
            CoroutineScope(Dispatchers.Main).launch {
                requireView().findNavController().navigate(
                    MuscleListFragmentDirections.actionMuscleListFragmentToLogInFragment()
                )
            }
        }
    }

}