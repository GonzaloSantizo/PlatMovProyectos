package com.plataformas.proyecto.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.plataformas.proyecto.data.dao.RegisterDao
import com.plataformas.proyecto.data.model.RegisterData

@Database(
    entities = [RegisterData::class],
    version = 1
)
abstract class RegisterDB : RoomDatabase(){

    abstract fun registerDao() : RegisterDao
}