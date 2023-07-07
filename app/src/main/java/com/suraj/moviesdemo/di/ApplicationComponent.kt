package com.suraj.moviesdemo.di

import com.suraj.moviesdemo.activity.MainActivity
import com.suraj.moviesdemo.ui.fragments.PlayingFragment
import com.suraj.moviesdemo.ui.fragments.PopulerFragment
import com.suraj.moviesdemo.ui.fragments.TopRatedFragment
import com.suraj.moviesdemo.ui.fragments.UpcomingFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])

interface ApplicationComponent {

    fun inject(playingFragment: PlayingFragment)

    fun inject(populerFragment: PopulerFragment)

    fun inject(topRatedFragment: TopRatedFragment)

    fun inject(upcomingFragment: UpcomingFragment)

}