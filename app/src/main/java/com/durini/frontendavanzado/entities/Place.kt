package com.durini.frontendavanzado.entities

import java.io.Serializable

data class Place(
    val name: String,
    val species: String,
    val status: String,
    val gender: String,
    var type: PlaceType
): Serializable

enum class PlaceType {
    Human,
    Alien,
}