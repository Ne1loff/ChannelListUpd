package com.example.channellistupd.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getPlaylist() = apiService.getPlayList()
}