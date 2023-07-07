package com.suraj.moviesdemo.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.suraj.moviesdemo.repository.MoviesRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val moviesRepository: MoviesRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(moviesRepository) as T
    }

}