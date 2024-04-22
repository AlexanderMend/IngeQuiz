package com.example.ingequiz.DataBase.Question

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "questions")
data class Questions(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "pregunta")
    val questionText: String,
    @ColumnInfo(name = "inciso1")
    val option1: String,
    @ColumnInfo(name = "inciso2")
    val option2: String,
    @ColumnInfo(name = "inciso3")
    val option3: String,
    @ColumnInfo(name = "inciso4")
    val option4: String,
    @ColumnInfo(name = "correcto")
    val correctAnswer: Int
)
