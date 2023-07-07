package com.suraj.moviesdemo.retrofit

import com.suraj.moviesdemo.model.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MoviesApi {

    @Headers("accept: application/json","Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhNDBiZDUyYmNhMTZhZjNiMDQ4ODhkNjQwMjE3ZjMyOCIsInN1YiI6IjY0OWJlYjJhOTYzODY0MDEzYTMyYmFhYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.XcP_gYVsPMdWNIG4lLdwDxWTkSDRYU6G6JH1IrIgKeI")
    @GET("now_playing?language=en-US&")
    suspend fun getNowPlayingMovies(@Query("page") page : Int) : Response<MoviesResponse>

    @Headers("accept: application/json","Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhNDBiZDUyYmNhMTZhZjNiMDQ4ODhkNjQwMjE3ZjMyOCIsInN1YiI6IjY0OWJlYjJhOTYzODY0MDEzYTMyYmFhYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.XcP_gYVsPMdWNIG4lLdwDxWTkSDRYU6G6JH1IrIgKeI")
    @GET("upcoming?language=en-US&")
    suspend fun getUpcomingMovies(@Query("page") page : Int) : Response<MoviesResponse>

    @Headers("accept: application/json","Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhNDBiZDUyYmNhMTZhZjNiMDQ4ODhkNjQwMjE3ZjMyOCIsInN1YiI6IjY0OWJlYjJhOTYzODY0MDEzYTMyYmFhYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.XcP_gYVsPMdWNIG4lLdwDxWTkSDRYU6G6JH1IrIgKeI")
    @GET("popular?language=en-US&")
    suspend fun getPopulerMovies(@Query("page") page : Int) : Response<MoviesResponse>

    @Headers("accept: application/json","Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhNDBiZDUyYmNhMTZhZjNiMDQ4ODhkNjQwMjE3ZjMyOCIsInN1YiI6IjY0OWJlYjJhOTYzODY0MDEzYTMyYmFhYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.XcP_gYVsPMdWNIG4lLdwDxWTkSDRYU6G6JH1IrIgKeI")
    @GET("top_rated?language=en-US&")
    suspend fun getTopRatedMovies(@Query("page") page : Int) : Response<MoviesResponse>



}