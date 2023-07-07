package com.suraj.moviesdemo.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.suraj.moviesdemo.model.Movies
import com.suraj.moviesdemo.retrofit.MoviesApi
import javax.inject.Inject
class MoviesRepository @Inject constructor(private val moviesApi: MoviesApi) {

    private val _movies = MutableLiveData<List<Movies>>()
    val movies: LiveData<List<Movies>>
        get() = _movies

    suspend fun getMovies(page: Int) {
        val result = moviesApi.getNowPlayingMovies(page)

        Log.e("moviesApi",result.body().toString())

        if (result.isSuccessful && result.body() != null) {
            _movies.postValue(result.body()!!.results)
        }
    }

    suspend fun getPopulerMovies(page: Int) {
        val result = moviesApi.getPopulerMovies(page)

        Log.e("moviesApi",result.body().toString())

        if (result.isSuccessful && result.body() != null) {
            _movies.postValue(result.body()!!.results)
        }
    }


    suspend fun getUpcomingMovies(page: Int) {
        val result = moviesApi.getUpcomingMovies(page)

        Log.e("moviesApi",result.body().toString())

        if (result.isSuccessful && result.body() != null) {
            _movies.postValue(result.body()!!.results)
        }
    }


    suspend fun getTopRatedMovies(page: Int) {
        val result = moviesApi.getTopRatedMovies(page)

        Log.e("moviesApi",result.body().toString())

        if (result.isSuccessful && result.body() != null) {
            _movies.postValue(result.body()!!.results)
        }
    }


}
