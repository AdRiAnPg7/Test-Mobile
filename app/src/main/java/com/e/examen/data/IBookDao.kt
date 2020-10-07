package com.e.examen.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.e.examen.model.Book

@Dao
interface IBookDao {

    @Insert(onConflict =  OnConflictStrategy.IGNORE)
    suspend fun addBook(book: Book)
    @Query( "SELECT * FROM book_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Book>>
}