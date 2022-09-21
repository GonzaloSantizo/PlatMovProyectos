package com.durini.frontendavanzado.database

import com.durini.frontendavanzado.entities.Place
import com.durini.frontendavanzado.entities.PlaceType
import java.util.*

object Database {

    fun randomId() = UUID.randomUUID().toString()

    private val places  = mutableListOf(
        Place(
            name = "Bicep",
            status = "Alive",
            species = "Human",
            gender = "Male",
            type = PlaceType.Human
        ),
        Place(
            name = "Tricep",
            status = "Alive",
            species = "Human",
            gender = "Male",
            type = PlaceType.Human
        ),
        Place(
            name = "Gluteos",
            status = "Alive",
            species = "Human",
            gender = "Female",
            type = PlaceType.Human
        ),
        Place(
            name = "Abdominales",
            status = "Alive",
            species = "Human",
            gender = "Female",
            type = PlaceType.Human
        ),
        Place(
            name = "Deltoides",
            status = "Alive",
            species = "Human",
            gender = "Male",
            type = PlaceType.Human
        ),
        Place(
            name = "Abadango Cluster Princess",
            status = "Alive",
            species = "Alien",
            gender = "Female",
            type = PlaceType.Alien
        ),
        Place(
            name = "Abradolf Lincler",
            status = "unknown",
            species = "Human",
            gender = "Male",
            type = PlaceType.Human
        ),
        Place(
            name = "Adjudicator Rick",
            status = "Dead",
            species = "Human",
            gender = "Male",
            type = PlaceType.Human
        ),
        Place(
            name = "Agency Director",
            status = "Dead",
            species = "Human",
            gender = "Male",
            type = PlaceType.Alien
        ),
        Place(
            name = "Alan Rails",
            status = "Dead",
            species = "Human",
            gender = "Male",
            type = PlaceType.Human
        ),
    )

    fun getPlaces() = places
}