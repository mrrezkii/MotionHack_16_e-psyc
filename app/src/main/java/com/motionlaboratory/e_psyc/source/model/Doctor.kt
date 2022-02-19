package com.motionlaboratory.e_psyc.source.model

data class Doctor(
    var key: String? = null,
    var name: String? = null,
    var schedule: String? = null,
    var rate: String? = null,
    var price: String? = null
)

fun mockDoctor(): ArrayList<Doctor> {
    val listAdapter: ArrayList<Doctor> = ArrayList()
    listAdapter.add(
        Doctor(
            null,
            "Rezki",
            "Senin - Jumat",
            "4.6",
            "Rp200.000"
        )
    )

    listAdapter.add(
        Doctor(
            null,
            "Nanda",
            "Senin - Jumat",
            "4.6",
            "Rp200.000"
        )
    )

    return listAdapter
}