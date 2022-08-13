package com.example.paralelos_movies.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: MainRepository) : BaseViewModel() {

    val moviesLiveData = MutableLiveData<List<Movie>>()

    fun getMovies() {
        repository.getMovies { movies ->
            moviesLiveData.postValue(movies)
        }
    }

    fun getMoviesCoroutines() {
        launch {
            val movies = withContext(Dispatchers.Default) {
                repository.getMoviesCoroutines()
            }
            moviesLiveData.value = movies
        }
    }

    class MainViewModelFactory(
        private val repository: MainRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }
    }

}