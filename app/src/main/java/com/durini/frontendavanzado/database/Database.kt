package com.durini.frontendavanzado.database

import com.durini.frontendavanzado.entities.Place
import com.durini.frontendavanzado.entities.PlaceType
import java.util.*

object Database {

    fun randomId() = UUID.randomUUID().toString()

    private val places  = mutableListOf(
        Place(
            name = "Bicep",
            status = "Ejercicio1: Curls con barra",
            species = "Ejercicio 2: Curls con mancuerna",
            gender = "Ejercicio 3: Remo inclinado",
            type = PlaceType.Human
        ),
        Place(
            name = "Tricep",
            status = "Ejercicio1: Flexiones con manos juntas",
            species = "Ejercicio 2: Extenciones en TRX",
            gender = "Ejercicio 3: Press Fr*nces",
            type = PlaceType.Human
        ),
        Place(
            name = "Gluteos",
            status = "Ejercicio1: peso muerto",
            species = "Ejercicio 2: Frog Pump",
            gender = "Ejercicio 3: Barbell hip thrust",
            type = PlaceType.Human
        ),
        Place(
            name = "Abdominales",
            status = "Ejercicio1: Crunches",
            species = "Ejercicio 2: Sit ups",
            gender = "Ejercicio 3: Russian Twist",
            type = PlaceType.Human
        ),
        Place(
            name = "Deltoides",
            status = "Ejercicio1: Press de hombro",
            species = "Ejercicio 2: levantamiento frontal",
            gender = "Ejercicio 3: Encogimiento de hombro",
            type = PlaceType.Human
        ),
        Place(
            name = "Pecho",
            status = "Ejercicio1: Push ups",
            species = "Ejercicio 2: Press de banca",
            gender = "Ejercicio 3: Flexion de arquero",
            type = PlaceType.Alien
        ),
        Place(
            name = "Pierna",
            status = "Ejercicio1: Sentadilla",
            species = "Ejercicio 2: Sentadilla con barra",
            gender = "Ejercicio 3: Sentadilla frontal",
            type = PlaceType.Human
        ),
        Place(
            name = "Hombro",
            status = "Ejercicio1: Press de hombro",
            species = "Ejercicio 2: levantamiento frontal",
            gender = "Ejercicio 3: Encogimiento de hombro",
            type = PlaceType.Human
        ),

    )

    fun getPlaces() = places
}