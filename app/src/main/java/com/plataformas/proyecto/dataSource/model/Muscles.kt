package com.plataformas.proyecto.dataSource.model

data class Muscles(
    val name: String,
    val exercises: String
)

object MuscleGroupsDB{
    private val muscles = mutableListOf(
        Muscles(
            name = "Espalda",
            exercises = "Pull ups"
        ),
        Muscles(
            name = "Pectoral",
            exercises = "Press banca"
        ),
        Muscles(
            name  = "Cuadriceps",
            exercises = "Sentadilla bulgara"
        ),
        Muscles(
            name = "Isquiosurales",
            exercises = "Curl isquiosurales"
        ),
        Muscles(
            name = "Bicep",
            exercises ="Curl con barra recta"
        ),
        Muscles(
           name = "Tricep",
            exercises = "Jalon con polea"
        )
    )
    fun getMuscles() = muscles
}
