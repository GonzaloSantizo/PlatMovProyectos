package com.plataformas.proyecto.data.dao

import androidx.room.*
import com.plataformas.proyecto.data.model.RegisterData

@Dao
interface RegisterDao {
    @Query("SELECT * FROM RegisterData")
    fun getAll():List<RegisterData>

    @Query("SELECT * FROM RegisterData WHERE id= :id")
    fun getById(id:Int): RegisterData

    @Update
    fun update(register: RegisterData)

    @Insert
    fun insert(register: List<RegisterData>)

    @Delete
    fun delete(register: RegisterData)
}
