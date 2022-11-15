package com.plataformas.proyecto.data.remote.firestore

/**
 * This data class it's use to define the data stored in the cloud from firestore.
 * The parameters are the data attributes.
 */
data class MusclesDto(
    val muscleName: String,
    val results : List<ExercisesDto>,
)
