package com.example.channellistupd.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Channel(
    val id: Long,
    val name_ru: String,
    val image: String,
    val current: Current?
)
