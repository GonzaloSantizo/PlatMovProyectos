package com.plataformas.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.plataformas.proyecto.R
import dagger.hilt.android.AndroidEntryPoint
import com.plataformas.proyecto.ui.fragments.HomeFragment
import com.plataformas.proyecto.ui.fragments.ExercisesFragment
import org.checkerframework.framework.qual.InvisibleQualifier

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //bottomNav = findViewById(R.id.bottomNavi_bottomNavActivity)
        //setCurrentFragment(HomeFragment())
        //setListeners()
    }

//    private fun setListeners(){
//        bottomNav.setOnItemSelectedListener {
//            // Dependiendo el item del menu, mostramos el fragment deseado
//            when(it.itemId) {
//                R.id.home_fragment -> setCurrentFragment(HomeFragment())
//                R.id.exercises_register -> setCurrentFragment(ExercisesFragment())
//            }
//            true
//        }
//    }
//
//    private fun setCurrentFragment(fragment: Fragment){
//        supportFragmentManager.commit {
//            setReorderingAllowed(true)
//            //addToBackStack(null)
//            replace(R.id.fragmentContainer, fragment)
//        }
//    }
}