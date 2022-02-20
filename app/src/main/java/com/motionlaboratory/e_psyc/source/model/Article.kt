package com.motionlaboratory.e_psyc.source.model

data class Article(
    val title: String? = null,
    val date: String? = null,
    val publisher: String? = null,
    val desc: String? = null
)

fun mockArticle(): ArrayList<Article> {
    val listAdapter: ArrayList<Article> = ArrayList()
    listAdapter.add(
        Article(
            "Kesehatan Mental"
        )
    )
    listAdapter.add(
        Article(
            "Berkenalan dengan Kesehatan Mental"
        )
    )
    listAdapter.add(
        Article(
            "Kegiatan Untuk Penghilang Beban"
        )
    )
    listAdapter.add(
        Article(
            "Ini yang Terjadi jika Anda Mengalami Stres"
        )
    )
    listAdapter.add(
        Article(
            "Tips untuk Menaikkan Mental Saat Down"
        )
    )

    return listAdapter
}