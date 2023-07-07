package com.suraj.moviesdemo.di

import android.app.Application

class MoviesApplication : Application() {

     lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().build()

    }

}