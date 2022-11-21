package com.plataformas.proyecto.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.plataformas.proyecto.data.model.RegisterData
import androidx.room.OnConflictStrategy

@Dao
interface RegisterDao {
    @Query("SELECT * FROM exerciseRegister_table ORDER BY id ASC")
    fun readAllData():LiveData<List<RegisterData>>

    @Update
    fun update(register: RegisterData)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addRegister(register:RegisterData)
    //fun insert(register: List<RegisterData>)

    @Delete
    fun delete(register: RegisterData)
}