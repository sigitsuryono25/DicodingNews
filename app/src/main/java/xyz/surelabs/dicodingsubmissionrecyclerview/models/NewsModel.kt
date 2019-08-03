package xyz.surelabs.dicodingsubmissionrecyclerview.models

import java.io.Serializable

data class NewsModel(
    var title: String?,
    var from: String = "Lifehacker.com",
    var pubDate: String?,
    var image: String,
    val url: String?,
    val content: String?
) : Serializable