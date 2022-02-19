package com.motionlaboratory.e_psyc.source.model

data class Chat(
    val doctor: Doctor,
    val lastMsg: String? = null,
)

fun mockChat(): ArrayList<Chat> {
    val listAdapter: ArrayList<Chat> = ArrayList()
    listAdapter.add(
        Chat(
            mockDoctor()[0],
            "Hallo dok, saya dengan saudara stefan"
        )
    )

    listAdapter.add(
        Chat(
            mockDoctor()[1],
            "Hallo saya dokter chelsea, apakah..."
        )
    )

    return listAdapter
}