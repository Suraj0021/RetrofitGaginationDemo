package com.suraj.moviesdemo.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.suraj.moviesdemo.R
import com.suraj.moviesdemo.databinding.FragmentPlayingBinding
import com.suraj.moviesdemo.di.MoviesApplication
import com.suraj.moviesdemo.model.Movies
import com.suraj.moviesdemo.ui.adapter.NowPlayingMoviesAdapter
import com.suraj.moviesdemo.viewModel.MainViewModel
import com.suraj.moviesdemo.viewModel.MainViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlayingFragment : Fragment() {

    private lateinit var binding: FragmentPlayingBinding


    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private var moviesList = ArrayList<Movies>()

    private lateinit var moviesAdapter: NowPlayingMoviesAdapter

    var page = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayingBinding.inflate(inflater)

        (requireActivity().application as MoviesApplication).applicationComponent.inject(this)

        setData()

        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setData() {

        moviesAdapter = NowPlayingMoviesAdapter(moviesList)

        moviesAdapter.setOnClickListener = SetOnClickListener()

        binding.rvNowPlayingMoviesList.adapter = moviesAdapter
        binding.rvNowPlayingMoviesList.layoutManager = GridLayoutManager(requireContext(), 2)

        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

        mainViewModel.moviesLiveData.observe(viewLifecycleOwner) { movie ->
            moviesList.addAll(movie)
            moviesAdapter.notifyDataSetChanged()
            binding.swipeRefreshLayout.isRefreshing = false

        }

        mainViewModel.viewModelScope.launch {
            mainViewModel.moviesRepository.getMovies(page)
        }

        binding.rvNowPlayingMoviesList.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val totalItemCount = layoutManager.itemCount
                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()

                if (lastVisibleItemPosition == totalItemCount - 3) {
                    page++

                    mainViewModel.viewModelScope.launch {
                        mainViewModel.moviesRepository.getMovies(page)
                    }
                }
            }
        })

        binding.swipeRefreshLayout.setOnRefreshListener {
            moviesList.clear()
            page = 1

            mainViewModel.viewModelScope.launch {
                mainViewModel.moviesRepository.getMovies(page)
            }

        }
    }


    inner class SetOnClickListener : NowPlayingMoviesAdapter.SetOnClickListener {
        override fun setOnClick(position: Int) {


        }

    }


}