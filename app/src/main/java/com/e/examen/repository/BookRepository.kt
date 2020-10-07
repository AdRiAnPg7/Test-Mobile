package com.e.examen.repository

import androidx.lifecycle.LiveData
import com.e.examen.data.IBookDao
import com.e.examen.model.Book

class BookRepository (private val bookDao: IBookDao) {

    val readAllData: LiveData<List<Book>> = bookDao.readAllData()

    suspend fun  addBook  (book: Book){
        bookDao.addBook(book)
    }

    suspend fun updateBook(book: Book){
        bookDao.updateBook(book)
    }
}