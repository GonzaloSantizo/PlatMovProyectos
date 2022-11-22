package com.plataformas.proyecto.data.repository.respositorydb

import androidx.lifecycle.LiveData
import com.plataformas.proyecto.data.dao.RegisterDao
import com.plataformas.proyecto.data.model.RegisterData

class RegisterRepository(
    private val registerDao : RegisterDao
) {
    val readAllData : LiveData<List<RegisterData>> = registerDao.readAllData()

    /**
     * Add a new register to the local db. This call the DAO, that is the data base
     */
    suspend fun addRegister(newRegister : RegisterData){
        registerDao.addRegister(newRegister)
    }

    /**
     * Update a register to local db. This call the DAO, that is the data base
     */
    suspend fun updateRegister(register : RegisterData){
        registerDao.updateRegister(register)
    }

    suspend fun deleteRegister(register : RegisterData){
        registerDao.deleteRegister(register)
    }

    suspend fun deleteAllRegisters(){
        registerDao.deleteAllRegisters()
    }
}