package com.suraj.moviesdemo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.suraj.moviesdemo.R
import com.suraj.moviesdemo.databinding.MovieViewBinding
import com.suraj.moviesdemo.model.Movies


class NowPlayingMoviesAdapter (val moviesList : ArrayList<Movies>) : RecyclerView.Adapter<NowPlayingMoviesAdapter.MoviesHolder>(){



    interface SetOnClickListener{
        fun setOnClick(position: Int)
    }

    var setOnClickListener: SetOnClickListener? = null

    fun setOnClickListener(listener: SetOnClickListener) {
        setOnClickListener = listener
    }


    class MoviesHolder(val view : View) : RecyclerView.ViewHolder(view){

        val binding : MovieViewBinding
        init {
            binding = MovieViewBinding.bind(view)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder {

  val view = MoviesHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_view,parent,false))

        return view
    }

    override fun getItemCount() = moviesList.size

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {

        setOnClickListener?.setOnClick(position)

        val data = moviesList[position]


        holder.binding.movies = data

        Picasso.get()
            .load("https://image.tmdb.org/t/p/w200/${data.poster_path}")
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(holder.binding.imgMoviePoster)
    }

}