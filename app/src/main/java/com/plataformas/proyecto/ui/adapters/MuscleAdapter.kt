package com.plataformas.proyecto.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import com.plataformas.proyecto.R
import com.plataformas.proyecto.data.remote.firestore.ExercisesDto

class MuscleAdapter(
    private val muscleList: ArrayList<ExercisesDto>
) : RecyclerView.Adapter<MuscleAdapter.ViewHolder>() {

    /**
     * Inner class for the neccesary data.
     */
    class ViewHolder(
        private val view: View,
    ) : RecyclerView.ViewHolder(view) {

        val exercise : TextView = view.findViewById(R.id.txtView_Adapter_exercise_name)
        val imageMuscle: ImageView = view.findViewById(R.id.recycler_itemImage)
        val muscleName: TextView = view.findViewById(R.id.txtView_Adapter_item_muscleGroup)
    }

    interface RecyclerViewExerciseEvents {
        fun onItemClicked(exercise: ExercisesDto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val exercise : ExercisesDto = muscleList[position]
        holder.muscleName.text = exercise.muscle
        holder.exercise.text = exercise.name
        holder.imageMuscle.load(exercise.image){
            memoryCachePolicy(CachePolicy.ENABLED)
            diskCachePolicy(CachePolicy.READ_ONLY)
            transformations(CircleCropTransformation())
        }
    }

    override fun getItemCount() : Int = muscleList.size

}