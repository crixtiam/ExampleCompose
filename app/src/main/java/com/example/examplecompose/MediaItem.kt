package com.example.examplecompose


data class MediaItem(
    val id: Int,
    val title: String,
    val thumb: String,
    val type: Type
){
    enum class Type{PHOTO,VIDEO}
}

fun getMedia() = (0..10).map{
    MediaItem(
        id = it,
        title = "My title $it",
        thumb = "https://loremflickr.com/320/240/$it",
        type = if (it%3 == 0) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO

        )
}
