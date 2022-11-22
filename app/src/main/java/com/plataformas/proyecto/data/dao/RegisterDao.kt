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
    suspend fun updateRegister (register: RegisterData)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addRegister(register:RegisterData)

    @Delete
    suspend fun deleteRegister(register: RegisterData)

    @Query("DELETE FROM exerciseRegister_table")
    suspend fun deleteAllRegisters()
}