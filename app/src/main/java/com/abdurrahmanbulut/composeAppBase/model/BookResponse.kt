package com.abdurrahmanbulut.composeAppBase.model

data class BookResponse(
    val items: List<VolumeInfo>
)

data class VolumeInfo(
    val volumeInfo: BookDetails
)

data class BookDetails(
    val title: String,
    val authors: List<String>?,
    val pageCount: Int?,
    val imageLinks: ImageLinks?,
    val categories: List<String>?,
    val description: String?
)
data class ImageLinks(
    val thumbnail: String?
)
