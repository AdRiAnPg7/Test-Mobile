package com.e.examen.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.e.examen.data.BookDatabase
import com.e.examen.repository.BookRepository
import com.e.examen.model.Book
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers

class BookViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Book>>
    private val repository: BookRepository
    init{
        val bookDao= BookDatabase.getDatabase(
            application
        ).bookDao()
        repository = BookRepository(bookDao)
        readAllData = repository.readAllData
    }

    fun addBook (book: Book){
        viewModelScope.launch(Dispatchers.IO){
            repository.addBook(book)
        }
    }
}