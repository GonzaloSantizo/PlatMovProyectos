package com.plataformas.proyecto.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.plataformas.proyecto.R
import com.plataformas.proyecto.data.remote.firestore.Excercises
import com.plataformas.proyecto.data.remote.firestore.Muscles

/**
 * This class it's use to put the data on the screen.
 */
class MuscleAdapter(private val muscleList : ArrayList<Muscles>) : RecyclerView.Adapter<MuscleAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_muscle_list,,
        parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val muscleGroup: Muscles = muscleList[position]
        holder.muscleName.text = muscleGroup.muscleName
        holder.muscleImage.text = muscleGroup.muscleImage
    }

    override fun getItemCount(): Int {
        return muscleList.size
    }

    public class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val muscleName : TextView = itemView.findViewById(R.id.recycler_muscleName)
        val muscleExercies : TextView = itemView.findViewById(R.id)
        val muscleImage : TextView = itemView.findViewById(R.id.recycler_itemImage)

    }
}