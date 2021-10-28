package com.example.channellistupd.data.repository

import com.example.channellistupd.data.api.ApiHelper

class MainRepo(private val apiHelper: ApiHelper) {

    suspend fun getPlaylist() = apiHelper.getPlaylist()
}