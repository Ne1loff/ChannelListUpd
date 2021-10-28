package com.example.channellistupd.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.channellistupd.data.model.Channel
import com.example.channellistupd.data.model.Playlist
import com.example.channellistupd.data.repository.MainRepo
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val mainRepo: MainRepo) : ViewModel() {

    fun getPlaylist() = liveData(Dispatchers.IO) {
        emit(Playlist(emptyList<Channel>().toMutableList()))
        try {
            val playlist = mainRepo.getPlaylist()
            emit(playlist)
        } catch (exception: Exception) {
            exception.printStackTrace()
            emit(Playlist(emptyList<Channel>().toMutableList()))
        }
    }
}