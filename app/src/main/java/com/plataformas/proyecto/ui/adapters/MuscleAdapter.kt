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
import com.plataformas.proyecto.data.remote.firestore.Exercises

class MuscleAdapter(
    private val dataSet: MutableList<Exercises>,
    private val listener: RecyclerViewMuscleEvents
) : RecyclerView.Adapter<MuscleAdapter.ViewHolder>() {

    class ViewHolder(
        private val view: View,
        private val listener: RecyclerViewMuscleEvents
    ) : RecyclerView.ViewHolder(view) {

        private val layoutMuscles: ConstraintLayout = view.findViewById(R.id.constraint_item)
        private val imageMuscle: ImageView = view.findViewById(R.id.recycler_itemImage)
        private val muscleName: TextView = view.findViewById(R.id.item_muscleGroup)

        fun setData(exercises: Exercises) {
            exercises.apply {
                imageMuscle.load(exercises.image) {
                    placeholder(androidx.appcompat.R.drawable.abc_btn_radio_material_anim)
                    transformations(CircleCropTransformation())
                    error(androidx.appcompat.R.drawable.abc_btn_borderless_material)
                    memoryCachePolicy(CachePolicy.ENABLED)
                    diskCachePolicy(CachePolicy.READ_ONLY)
                }
                muscleName.text = name

            }
            layoutMuscles.setOnClickListener {
                listener.onItemClicked(exercises)
            }
        }

    }

    interface RecyclerViewMuscleEvents {
        fun onItemClicked(exercises: Exercises)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item, parent, false)

        return ViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(dataSet[position])
    }

    override fun getItemCount() : Int =
         dataSet.size

}