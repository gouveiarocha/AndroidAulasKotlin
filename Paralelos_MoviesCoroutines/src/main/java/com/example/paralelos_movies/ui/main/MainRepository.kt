package com.example.paralelos_movies.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepository {

    fun getMovies(callback: (movies: List<Movie>) -> Unit) {
        // Simular Nova Thread do Java
        Thread(Runnable {
            // 3 segundos...
            Thread.sleep(3000)
            callback.invoke(
                listOf(
                    Movie(1, "Titulo 1"),
                    Movie(2, "Titulo 2")
                )
            )
        }).start()
    }

    suspend fun getMoviesCoroutines(): List<Movie> {
        return withContext(Dispatchers.Default) {
            delay(3000L)
            listOf(
                Movie(1, "Titulo 1 - Haha"),
                Movie(2, "Titulo 2")
            )
        }
    }

}