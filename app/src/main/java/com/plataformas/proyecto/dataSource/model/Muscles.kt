package com.plataformas.proyecto.dataSource.model

data class Muscles(
    val name: String,
    val exersises: String
)

object MuscleGroupsDB{
    private val muscles = mutableListOf(
        Muscles(
            name = "Espalda",
            exersises = "Pull ups"
        ),
        Muscles(
            name = "Pectoral",
            exersises = "Press banca"
        ),
        Muscles(
            name  = "Cuadriceps",
            exersises = "Sentadilla bulgara"
        ),
        Muscles(
            name = "Isquiosurales",
            exersises = "Curl isquiosurales"
        ),
        Muscles(
            name = "Bicep",
            exersises ="Curl con barra recta"
        ),
        Muscles(
           name = "Tricep",
           exersises = "Jalon con polea"
        )
    )
    fun getMuscles() = muscles
}
