package com.plataformas.proyecto.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import com.plataformas.proyecto.R
import com.plataformas.proyecto.data.model.RegisterData
import com.plataformas.proyecto.data.remote.firestore.ExercisesDto
import com.plataformas.proyecto.ui.fragments.list.ExercisesFragment
import com.plataformas.proyecto.ui.fragments.list.ExercisesFragmentDirections
import kotlinx.android.synthetic.main.recycler_register.view.*

class RegisterAdapter : RecyclerView.Adapter<RegisterAdapter.MyViewHolder> (){

    private var registerList = emptyList<RegisterData>()

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var index : TextView = itemView.findViewById(R.id.txtView_index)
        var exercises: TextView = itemView.findViewById(R.id.txtView_exerciseData)
        var weight : TextView = itemView.findViewById(R.id.txtView_weightData)
        var description : TextView = itemView.findViewById(R.id.txtView_description)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_register, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currencItem = registerList[position]
        holder.index.text = currencItem.id.toString()
        holder.exercises.text = currencItem.exercise.toString()
        holder.weight.text = currencItem.weight.toString()
        holder.description.text = currencItem.description.toString()
        holder.itemView.constraint_item.setOnClickListener{
            val action = ExercisesFragmentDirections.actionExercisesFragmentToUpdateFragment(currencItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount() = registerList.size

    fun setData(register : List<RegisterData>){
        this.registerList = register
        notifyDataSetChanged()
    }
}