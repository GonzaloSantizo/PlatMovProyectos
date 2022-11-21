package com.plataformas.proyecto.data.repository.respositorydb

import androidx.lifecycle.LiveData
import com.plataformas.proyecto.data.dao.RegisterDao
import com.plataformas.proyecto.data.model.RegisterData

class RegisterRepository(
    private val registerDao : RegisterDao
) {
    val readAllData : LiveData<List<RegisterData>> = registerDao.readAllData()

    suspend fun addRegister(newRegister : RegisterData){
        registerDao.addRegister(newRegister)
    }
}