package com.abdurrahmanbulut.composeAppBase.ui.main.allBooks

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdurrahmanbulut.composeAppBase.model.BookItem
import com.abdurrahmanbulut.composeAppBase.model.BookResponse
import com.abdurrahmanbulut.composeAppBase.model.VolumeInfo
import com.abdurrahmanbulut.composeAppBase.network.repository.BookRepository
import createEventWithOneArg

class AllBooksScreenVM(private val bookRepository: BookRepository) : ViewModel() {

    var title by mutableStateOf("Tüm Kitaplar")

    val navigateToDetail = createEventWithOneArg<BookItem?>()
    var books by mutableStateOf<BookResponse?>(null)

    val bookCategories = listOf(
        BookCategory.KURGU.categoryName,
        BookCategory.BILIM.categoryName,
        BookCategory.TARIH.categoryName,
        BookCategory.BIYOGRAFI_OTOBIYOGRAFI.categoryName,
        BookCategory.KISISEL_GELISIM.categoryName,
        BookCategory.SAGLIK_FITNESS.categoryName,
        BookCategory.TEKNOLOJI.categoryName,
        BookCategory.IS_EKONOMI.categoryName,
        BookCategory.FANTASTIK.categoryName,
        BookCategory.COCUK_KITAPLARI.categoryName
    )

    private var selectedCategory by mutableStateOf("")

    init {
        getAllBooks()
    }

    private fun getAllBooks(){
        bookRepository.getBooks(viewModelScope, "books")
            .success {
                books = it
            }
            .failure {
            }
    }

    fun onClickBook(detail: BookItem?){
        navigateToDetail.trigger(detail)
    }

    fun onClickCategory(category: String){
        selectedCategory = BookCategory.entries.find { it.categoryName == category }?.categoryName ?: "books"
        val enCategoryName = BookCategory.entries.find { it.categoryName == category }?.englishCategoryName ?: "books"
        val query = "subject${enCategoryName}"
        bookRepository.getBooks(viewModelScope, query).success {
            books = it
            title = selectedCategory + " - ${it.totalItems.toString()} Sonuç"
        }
    }
}
enum class BookCategory(val categoryName: String, val englishCategoryName: String) {
    KURGU("Kurgu", "Fiction"),
    BILIM("Bilim", "Science"),
    TARIH("Tarih", "History"),
    BIYOGRAFI_OTOBIYOGRAFI("Biyografi & Otobiyografi", "Biography & Autobiography"),
    KISISEL_GELISIM("Kişisel Gelişim", "Self-Help"),
    SAGLIK_FITNESS("Sağlık & Fitness", "Health & Fitness"),
    TEKNOLOJI("Teknoloji", "Technology"),
    IS_EKONOMI("İş & Ekonomi", "Business & Economics"),
    FANTASTIK("Fantastik", "Fantasy"),
    COCUK_KITAPLARI("Çocuk Kitapları", "Children's Books")
}
