package com.suraj.moviesdemo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suraj.moviesdemo.model.Movies
import com.suraj.moviesdemo.repository.MoviesRepository
import kotlinx.coroutines.launch

class MainViewModel(val moviesRepository: MoviesRepository) : ViewModel() {

    val moviesLiveData: LiveData<List<Movies>>

        get() = moviesRepository.movies

}