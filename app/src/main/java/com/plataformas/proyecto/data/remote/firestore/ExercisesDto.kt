package com.plataformas.proyecto.data.remote.firestore

data class ExercisesDto(
    var name: String ?= null,
    var muscle: String ?= null,
    var description: String ?= null,
    var image : String ?= null
)
