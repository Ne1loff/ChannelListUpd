package com.example.channellistupd.data.api

import com.example.channellistupd.data.model.Playlist
import retrofit2.http.GET

interface ApiService {

    @GET("playlist")
    suspend fun getPlayList(): Playlist
}