package com.example.gouveiarocha.estudoskotlin.Paralelos.Exercicios

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ExerciciosTests {

    @DisplayName("1- Encontre o ultimo elemento de uma lista.")
    @Test
    fun ex1() {
        fun <T> ultimo(list: List<T>): T? = if (list.isNotEmpty()) list[list.lastIndex] else null
        assertEquals(ultimo(listOf(1, 2, 3, 4, 5, 6, 7, 8)), 8)
        assertEquals(ultimo(listOf(1)), 1)
        assertEquals(ultimo(emptyList<Int>()), null)

    }

    @DisplayName("2- Encontre o penultimo elemento de uma lista.")
    @Test
    fun ex2() {

        fun <T> penultimo(list: List<T>): T? =
            if (list.isNotEmpty() && list.size > 1) list[list.lastIndex - 1] else null

        assertEquals(penultimo(listOf(1, 2, 3, 4, 5, 6, 7, 8)), 7)
        assertEquals(penultimo(listOf(1)), null)
        assertEquals(penultimo(emptyList<Int>()), null)
    }



}