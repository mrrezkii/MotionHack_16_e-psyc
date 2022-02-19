package com.motionlaboratory.e_psyc.ui.main

import androidx.lifecycle.ViewModel
import com.motionlaboratory.e_psyc.source.model.Doctor
import com.motionlaboratory.e_psyc.source.network.EPsycRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    val repository: EPsycRepository
) : ViewModel() {
    var doctor: Doctor? = null

    val doctors = repository.doctor
    val message = repository.message

    fun getDoctor() = CoroutineScope(Dispatchers.IO).launch {
        repository.getDoctor()
    }
}
