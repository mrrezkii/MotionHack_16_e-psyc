package com.motionlaboratory.e_psyc.source.network

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.motionlaboratory.e_psyc.source.model.Doctor
import com.motionlaboratory.e_psyc.utils.post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EPsycRepository {
    companion object {
        const val TABLE_DOCTOR = "doctor"
    }

    private val firebaseDatabase by lazy { FirebaseDatabase.getInstance() }

    val doctor: LiveData<List<Doctor>> = MutableLiveData()

    val isLoading: LiveData<Boolean> = MutableLiveData()
    val message: LiveData<String> = MutableLiveData()

    suspend fun getDoctor() = withContext(Dispatchers.IO) {
        isLoading.post(true)
        val ref = firebaseDatabase
            .reference
            .child(TABLE_DOCTOR)
        ref.addValueEventListener(getDoctorValueListener())
        ref.keepSynced(true)
    }

    private fun getDoctorValueListener() = object : ValueEventListener {
        override fun onCancelled(error: DatabaseError) {
            isLoading.post(false)
            message.post("$error")
        }

        @RequiresApi(Build.VERSION_CODES.O)
        override fun onDataChange(snapshot: DataSnapshot) {
            isLoading.post(false)

            val doctorResult = mutableListOf<Doctor>()
            snapshot.children.forEach { dataSnapshot ->
                dataSnapshot.getValue(Doctor::class.java)?.let { doctor ->
                    doctor.key = dataSnapshot.key
                    doctor.name = dataSnapshot.child("name").value.toString()
                    doctor.schedule = dataSnapshot.child("schedule").value.toString()
                    doctor.rate = dataSnapshot.child("rate").value.toString()
                    doctor.price = dataSnapshot.child("price").value.toString()
                    doctorResult.add(
                        Doctor(
                            key = doctor.key,
                            name = doctor.name,
                            schedule = doctor.schedule,
                            rate = doctor.rate,
                            price = doctor.price
                        )
                    )
                }
            }
            doctor.post(doctorResult)
        }
    }
}