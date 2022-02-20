package com.motionlaboratory.e_psyc.source.model
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ticket(
    var key: String? = null,
    var name: String? = null,
    var date: String? = null,
    var schedule: String? = null,
    var photo: String? = null
) : Parcelable

fun mockTicket(): ArrayList<Ticket> {
    val listAdapter: ArrayList<Ticket> = ArrayList()
    listAdapter.add(
        Ticket(
            null,
            "Mencegah Penurunan Mental",
            "15 Maret 2022",
            "13:00 - 16:00",
            "https://islamic-education.uii.ac.id/wp-content/uploads/2018/03/BANNER-SEMINAR.png"
        )
    )

    listAdapter.add(
        Ticket(
            null,
            "Mengelola Emosi Pribadi",
            "19 April 2022",
            "11:00 - 13:00",
            "https://www.pixelldesign.com/wp-content/uploads/desain-banner-spanduk-seminar-workshop-simposium-kedokteran-8.jpg"
        )
    )

    return listAdapter
}