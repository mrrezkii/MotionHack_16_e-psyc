package com.motionlaboratory.e_psyc.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.motionlaboratory.e_psyc.source.network.EPsycRepository

class MainViewModelFactory(
    private val repository: EPsycRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}