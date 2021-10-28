package com.example.channellistupd.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Playlist(
    val channels: MutableList<Channel>
)
