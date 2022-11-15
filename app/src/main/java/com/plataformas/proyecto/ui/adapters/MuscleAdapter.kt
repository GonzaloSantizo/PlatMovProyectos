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
import com.plataformas.proyecto.data.remote.firestore.MusclesDto

/**
 * This class it's use to put the data on the screen.
 */
class MuscleAdapter(
    private val dataSet : MutableList<ExercisesDto>,
    private val listener: RecyclerViewMuscleEvents
    ) : RecyclerView.Adapter<MuscleAdapter.MyViewHolder>() {


    public class MyViewHolder(
        private val view: View,
        private val listener: RecyclerViewMuscleEvents
    ) : RecyclerView.ViewHolder(view){
        private val layoutCharacter: ConstraintLayout = view.findViewById(R.id.constraintLayout_muscleShows)
        private val muscleName: TextView = view.findViewById(R.id.recycler_muscleName)
        private val imageExercise: ImageView = view.findViewById(R.id.recycler_itemImage)

        val exercise : TextView = itemView.findViewById(R.id.recycler_muscleName)
        val muscleImage : ImageView = itemView.findViewById(R.id.recycler_itemImage)
        fun setData(muscle: ExercisesDto) {
            muscle.apply {
                muscleName.text = muscleName.toString()
            }
            layoutCharacter.setOnClickListener {
                listener.onItemClicked(muscle)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item, parent, false)

        return MyViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setData(dataSet[position])

    }

    override fun getItemCount() = dataSet.size

    /**
     * Interfaz useful to the function of each muscle group, is like a card view
     */
    interface RecyclerViewMuscleEvents {
        fun onItemClicked(muscle: ExercisesDto)
    }

}