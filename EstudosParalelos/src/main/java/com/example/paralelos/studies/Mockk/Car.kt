package com.example.paralelos.studies.Mockk

open class Car {

    val NORTH = "NORTH"
    val SOUTH = "SOUTH"
    val EAST = "EAST"
    val WEST = "WEST"
    val INCORRECT_DIRECTION = "Incorrect Direction"

    fun drive(direction: Direction): Result {
        return Result.OK
    }

    fun myDrive(direction: String): String {
        direction.toLowerCase()
        return when (direction) {
            "norte" -> NORTH
            "sul" -> SOUTH
            "leste" -> EAST
            "oeste" -> WEST
            else -> INCORRECT_DIRECTION
        }

    }

}