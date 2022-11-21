package com.plataformas.proyecto.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.plataformas.proyecto.data.database.RegisterDB
import com.plataformas.proyecto.data.model.RegisterData
import com.plataformas.proyecto.data.repository.respositorydb.RegisterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel(application : Application) : AndroidViewModel(application) {

    
    /**
    * 
    * variables to read data from user
    * 
    */
    
    private val readAllData : LiveData<List<RegisterData>>
    private val repository : RegisterRepository
    
    /**
    * 
    * Initialice register
    * 
    */
    
    
    init{
        val registerDao = RegisterDB.getDataBase(application).registerDao()
        repository = RegisterRepository(registerDao)
        readAllData = repository.readAllData
    }

    fun addRegister(register : RegisterData){
        viewModelScope.launch(Dispatchers.IO){
            repository.addRegister(register)
        }
    }
}
