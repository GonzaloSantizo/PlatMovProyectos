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
    private val muscleList: ArrayList<ExercisesDto>
) : RecyclerView.Adapter<MuscleAdapter.ViewHolder>() {

    public class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val muscle : TextView = view.findViewById(R.id.txtView_Adapter_item_muscleGroup)
        val exercises: TextView = view.findViewById(R.id.txtView_Adapter_exercise_name)
        val image : ImageView = view.findViewById(R.id.recycler_itemImage)
    }

    interface RecyclerViewExerciseEvents {
        fun onItemClicked(character: Character)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val exercise : ExercisesDto = muscleList[position]
        holder.muscle.text = exercise.muscle
        holder.exercises.text = exercise.name
        holder.image.load(exercise.image){
            transformations(CircleCropTransformation())
            memoryCachePolicy(CachePolicy.ENABLED)
            diskCachePolicy(CachePolicy.READ_ONLY)
        }
    }

    override fun getItemCount(): Int = muscleList.size
}

