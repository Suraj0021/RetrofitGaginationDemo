package com.suraj.moviesdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.navArgument
import com.squareup.picasso.Picasso
import com.suraj.moviesdemo.R
import com.suraj.moviesdemo.databinding.ActivityMovieDetailsBinding
import com.suraj.moviesdemo.model.Movies

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)

        setContentView(binding.root)



    }
}