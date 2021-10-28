package com.example.channellistupd.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.channellistupd.R
import com.example.channellistupd.data.api.ApiHelper
import com.example.channellistupd.data.api.RetrofitBuilder
import com.example.channellistupd.data.model.Channel
import com.example.channellistupd.data.model.Playlist
import com.example.channellistupd.ui.base.ViewModelFactory
import com.example.channellistupd.ui.main.adapter.MainAdapter
import com.example.channellistupd.ui.main.viewmodel.MainViewModel
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupUI()
        setupObservers()
    }

    private fun setupViewModel() {
        viewModel =
            ViewModelProvider(this, ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))).get(
                MainViewModel::class.java
            )
    }

    private fun setupUI() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(Playlist(emptyList<Channel>().toMutableList()))
        recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getPlaylist().observe(this) {
            it?.let { resource ->
                if (resource.channels.isNotEmpty()) {
                    retrieveList(resource)
                }
            }
        }
    }

    private fun retrieveList(playlist: Playlist) {
        adapter.apply {
            addChannels(playlist)
            notifyDataSetChanged()
        }
    }
}