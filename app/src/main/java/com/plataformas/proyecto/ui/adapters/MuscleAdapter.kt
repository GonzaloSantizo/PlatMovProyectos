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
import org.w3c.dom.Text

class MuscleAdapter(
    private val muscleList: ArrayList<ExercisesDto>,
    private val listener : RecyclerViewExerciseEvents
) : RecyclerView.Adapter<MuscleAdapter.ViewHolder>() {


    inner class ViewHolder(view: View, private val listener: RecyclerViewExerciseEvents): RecyclerView.ViewHolder(view){
        val layoutExercise : ConstraintLayout = view.findViewById(R.id.constraint_item)
        var muscle : TextView = view.findViewById(R.id.txtView_Adapter_item_muscleGroup)
        var exercises: TextView = view.findViewById(R.id.txtView_Adapter_exercise_name)
        var image : ImageView = view.findViewById(R.id.recycler_itemImage)

        fun setData(exercise: ExercisesDto){
            image.load(exercise.image){
                transformations(CircleCropTransformation())
                memoryCachePolicy(CachePolicy.ENABLED)
                diskCachePolicy(CachePolicy.READ_ONLY)
            }
            muscle.text = exercise.muscle
            exercises.text = exercise.name
            layoutExercise.setOnClickListener{
                listener.onItemClicked(exercise)
            }
        }
    }

    interface RecyclerViewExerciseEvents {
        fun onItemClicked(exercise: ExercisesDto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent,false)
        return ViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(muscleList[position])
    }

    override fun getItemCount(): Int = muscleList.size
}

