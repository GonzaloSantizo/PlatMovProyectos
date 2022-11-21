package com.plataformas.proyecto.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.plataformas.proyecto.R
import com.plataformas.proyecto.data.remote.firestore.ExercisesDto
import com.plataformas.proyecto.ui.adapters.MuscleAdapter


/**
 * A simple [Fragment] subclass.
 * Use the [ExercisesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExercisesFragment : Fragment(R.layout.fragment_exercises) {
    private lateinit var toolbar: MaterialToolbar
    private lateinit var recyclerExercises: RecyclerView
    private lateinit var bottomNav : BottomNavigationView
    private lateinit var addRegisterButton : FloatingActionButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initializing components, see fragment_muscle_list
        toolbar = view.findViewById(R.id.toolbar_exerciseRegisterFragment)
        recyclerExercises = view.findViewById(R.id.recycler_exercisesRegisterFragment)
        addRegisterButton = view.findViewById(R.id.btn_exerciseRegisterFragment_addNewRegister)
        bottomNav = view.findViewById(R.id.bottomNavi_bottomNavFragment_exerciseRegister)
        bottomNav.visibility = View.VISIBLE
        setToolBar()

        setListeners()

    }


    private fun setToolBar(){
        val navController = findNavController()
        val appbarConfig = AppBarConfiguration(setOf(R.id.exercisesFragment))
        toolbar.setupWithNavController(navController, appbarConfig)
    }

    private fun setListeners() {
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.muscleListFragment,R.id.exercisesFragment))
        bottomNav.setupWithNavController(navController)
        toolbar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId) {
                R.id.menu_item_darkMode -> {
                    true
                }

                R.id.menu_item_logout -> {
                    true
                }
                else -> true
            }
        }
        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home_fragment -> {
                    requireView().findNavController().navigate(ExercisesFragmentDirections.actionExercisesFragmentToMuscleListFragment())
                    true
                }
                R.id.exercises_register -> {
                    requireView().findNavController().navigate(ExercisesFragmentDirections.actionExercisesFragmentSelf())
                    true
                }
            }
            true
        }

        addRegisterButton.setOnClickListener{
            val action = ExercisesFragmentDirections.actionExercisesFragmentToAddingRegisterragment()
            requireView().findNavController().navigate(action)
        }
    }
}