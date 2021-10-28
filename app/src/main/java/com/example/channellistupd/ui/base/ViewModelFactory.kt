package com.example.channellistupd.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.channellistupd.data.api.ApiHelper
import com.example.channellistupd.data.repository.MainRepo
import com.example.channellistupd.ui.main.viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepo(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}