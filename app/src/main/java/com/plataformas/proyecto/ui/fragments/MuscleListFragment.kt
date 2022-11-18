package com.plataformas.proyecto.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.plataformas.proyecto.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MuscleListFragment : Fragment(R.layout.fragment_muscle_list) {
    private lateinit var toolbar: MaterialToolbar
    private lateinit var recyclerMuscles:RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
        }
        // Initialazing components, see fragment_muscle_list
        toolbar = view.findViewById(R.id.toolbar_muscleList)
        recyclerMuscles = view.findViewById(R.id.recycler_muscles)
        setToolBar()
        setListeners()
    }

    /*
        Setting the toolbar to show the neccesary data to the fragent
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
                    //logout()
                    true

                }
                else -> true
            }
        }
    }

//    override fun onItemClicked(){
//
//    }
//    private fun logout() {
//        CoroutineScope(Dispatchers.IO).launch {
//            requireContext().dataStore.removePreferencesValue(KEY_MAIL)
//            CoroutineScope(Dispatchers.Main).launch {
//                requireView().findNavController().navigate(
//                    CharacterListFragmentDirections.actionCharacterListFragmentToLoginFragment()
//                )
//            }
//        }
//    }

}