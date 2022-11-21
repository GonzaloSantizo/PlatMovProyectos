package com.plataformas.proyecto.data.database

import android.app.Application
import androidx.room.Room

class RegisterApp : Application() {
    val room = Room.databaseBuilder(this, RegisterDB::class.java,"training")
        .build()
}
