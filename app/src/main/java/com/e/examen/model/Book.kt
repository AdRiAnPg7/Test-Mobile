package com.e.examen.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity  (tableName="book_table")
data class Book (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val pages: Int,
    val  editorial: String,
    val author: String,
    val description: String,
    val photoUrl:String
)