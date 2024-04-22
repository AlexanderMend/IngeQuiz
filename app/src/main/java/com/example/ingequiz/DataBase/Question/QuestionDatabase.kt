package com.example.ingequiz.DataBase.Question

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Questions::class], version = 1)
abstract class QuestionDatabase : RoomDatabase() {
    abstract fun questionDao(): QuestionDao

    companion object {
        private const val DATABASE_NAME = "question_database"

        fun getInstance(context: Context): QuestionDatabase
        {
            return Room.databaseBuilder(context, QuestionDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }
}
