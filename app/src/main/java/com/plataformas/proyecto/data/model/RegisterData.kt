package com.plataformas.proyecto.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.ParcelField
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "exerciseRegister_table")
data class RegisterData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name="name_exercise") val exercise: String?,
    @ColumnInfo(name="description") val description: String?,
    @ColumnInfo(name="amount_wight") val weight: Int
):Parcelable
