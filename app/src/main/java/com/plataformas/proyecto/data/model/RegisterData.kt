package com.plataformas.proyecto.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RegisterData(
    @PrimaryKey(autoGenerate = true) val registerid: Int = 0,
    @ColumnInfo(name="name_exercise") val exercise: String?,
    @ColumnInfo(name="description") val description: String?,
    @ColumnInfo(name="amount_wight") val weight: String?
)
