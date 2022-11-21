package com.plataformas.proyecto.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.plataformas.proyecto.R
import com.plataformas.proyecto.data.remote.firestore.ExercisesDto
import com.plataformas.proyecto.ui.adapters.MuscleAdapter
import com.plataformas.proyecto.ui.viewmodel.itemViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MuscleListFragment : Fragment(R.layout.fragment_muscle_list), MuscleAdapter.RecyclerViewExerciseEvents{
    private lateinit var toolbar: MaterialToolbar
    private lateinit var recyclerMuscles:RecyclerView
    private lateinit var adapter: MuscleAdapter
    private lateinit var db: FirebaseFirestore
    private lateinit var exercisesArrayList : ArrayList<ExercisesDto>
    private lateinit var description : TextView
    private lateinit var auth : FirebaseAuth

    private lateinit var bottomNav : BottomNavigationView

    //private val viewModel : itemViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initializing components, see fragment_muscle_list
        toolbar = view.findViewById(R.id.toolbar_muscleList)
        recyclerMuscles = view.findViewById(R.id.recycler_muscles)
        auth= Firebase.auth
        exercisesArrayList = arrayListOf()

        bottomNav = view.findViewById(R.id.bottomNavi_bottomNavFragment)
        bottomNav.visibility = View.VISIBLE

       // viewModel.bottomNav = view.findViewById(R.id.bottomNavi_bottomNavFragment)
      //  viewModel.bottomNav.visibility = View.VISIBLE

        setToolBar()

        setListeners()
        EventChangeListener()
    }

    private fun EventChangeListener(){
        db = FirebaseFirestore.getInstance()
        db.collection("dbmuscles").
            addSnapshotListener(object: EventListener<QuerySnapshot> {
                override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                    if(error != null){
                        Log.e("Firestore error", error.message.toString())
                        return
                    }
                    for(dc:DocumentChange in value?.documentChanges!!){
                        if(dc.type == DocumentChange.Type.ADDED){
                            exercisesArrayList.add(dc.document.toObject(ExercisesDto::class.java))
                        }
                    }
                    setupRecycler(exercisesArrayList)
                    adapter.notifyDataSetChanged()

                }
            })
    }
    /*
        Setting the toolbar to show the necessary data to the fragment
     */
    private fun setupRecycler(exercise: ArrayList<ExercisesDto>) {
        adapter = MuscleAdapter(exercisesArrayList, this)
        recyclerMuscles.layoutManager = LinearLayoutManager(requireContext())
        recyclerMuscles.setHasFixedSize(true)
        recyclerMuscles.adapter = adapter
    }


    private fun setToolBar(){
        val navController = findNavController()
        val appbarConfig = AppBarConfiguration(setOf(R.id.muscleListFragment))
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
                    logout()
                    true
                }
                else -> true
            }
        }
        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home_fragment -> {
                    requireView().findNavController().navigate(MuscleListFragmentDirections.actionMuscleListFragmentSelf())
                    true
                }
                R.id.exercises_register -> {
                    requireView().findNavController().navigate(MuscleListFragmentDirections.actionMuscleListFragmentToExercisesFragment())
                    true
                }
            }
            true
        }

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

    override fun onItemClicked(exercise: ExercisesDto) {
        db = FirebaseFirestore.getInstance()

        val action = MuscleListFragmentDirections.actionMuscleListFragmentToMuscleDetailsFragment(
            exercise.name.toString(), exercise.muscle.toString(), exercise.description.toString(), exercise.image.toString()
        )
        requireView().findNavController().navigate(action)
    }
}