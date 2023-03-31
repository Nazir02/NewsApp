package com.example.newsapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.newsapp.R
import com.example.newsapp.adapter.LoaderStateAdapterRv
import com.example.newsapp.adapter.PagingAdapter
import com.example.newsapp.room.NewsViewModelDB
import com.example.newsapp.vm.ViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.flow.collectLatest
import java.io.IOException
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    val vm: ViewModelFactory by viewModels()
    val vmDatabase:NewsViewModelDB by viewModels()

    @Inject
    lateinit var adapter: PagingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        lifecycleScope.launchWhenStarted {
            initRecyclerview()
            vm.getAllNews.collectLatest { response ->
                adapter.submitData(response)

            }
        }
        return view
    }

    private fun initRecyclerview() {
        try {
                mainRecyclerView.adapter = adapter
                mainRecyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
                    header = LoaderStateAdapterRv { adapter.retry() },
                    footer = LoaderStateAdapterRv { adapter.retry() },
                )
        } catch (exception: IOException) {
            Log.d("testttt", exception.message.toString())
        }
    }
}
