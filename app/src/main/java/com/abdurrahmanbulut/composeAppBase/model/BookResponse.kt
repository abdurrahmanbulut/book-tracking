package com.abdurrahmanbulut.composeAppBase.model


data class BookResponse(
    val kind: String?,
    val totalItems: Int?,
    val items: List<BookItem>?
)

data class BookItem(
    val kind: String?,
    val id: String,
    val etag: String,
    val selfLink: String,
    val volumeInfo: VolumeInfo,
    val saleInfo: SaleInfo,
    val accessInfo: AccessInfo,
    val searchInfo: SearchInfo?
)

data class VolumeInfo(
    val title: String,
    val authors: List<String>?,
    val publisher: String?,
    val publishedDate: String?,
    val description: String?,
    val pageCount: Int?,
    val categories: List<String>?,
    val averageRating: Float?,
    val ratingsCount: Int?,
    val maturityRating: String?,
    val imageLinks: ImageLinks?,
    val language: String?,
    val previewLink: String?,
    val infoLink: String?,
    val canonicalVolumeLink: String?
)

data class ImageLinks(
    val smallThumbnail: String?,
    val thumbnail: String?
)

data class SaleInfo(
    val country: String,
    val saleability: String,
    val isEbook: Boolean,
    val listPrice: Price?,
    val retailPrice: Price?,
    val buyLink: String?
)

data class Price(
    val amount: Double,
    val currencyCode: String
)

data class AccessInfo(
    val country: String,
    val viewability: String,
    val embeddable: Boolean,
    val publicDomain: Boolean,
    val textToSpeechPermission: String,
    val epub: EpubInfo,
    val pdf: PdfInfo,
    val webReaderLink: String?,
    val accessViewStatus: String,
    val quoteSharingAllowed: Boolean
)

data class EpubInfo(
    val isAvailable: Boolean
)

data class PdfInfo(
    val isAvailable: Boolean
)

data class SearchInfo(
    val textSnippet: String?
)
