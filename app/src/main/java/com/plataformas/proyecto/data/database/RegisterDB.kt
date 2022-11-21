package com.plataformas.proyecto.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.plataformas.proyecto.data.dao.RegisterDao
import com.plataformas.proyecto.data.model.RegisterData
import android.content.Context
import androidx.room.Room

@Database(
    entities = [RegisterData::class],
    version = 1,
    exportSchema = false
)
abstract class RegisterDB : RoomDatabase(){

    abstract fun registerDao() : RegisterDao

    companion object{
        @Volatile
        private var INSTANCE: RegisterDB? = null

        fun getDataBase(context: Context) : RegisterDB{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return  tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RegisterDB::class.java,
                    "register_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}