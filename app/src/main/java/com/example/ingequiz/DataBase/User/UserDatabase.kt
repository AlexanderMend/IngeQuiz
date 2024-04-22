package com.example.ingequiz.DataBase.User

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Users::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private const val DATABASE_NAME = "user_database"

        fun getInstance(context: Context): UserDatabase {
            return Room.databaseBuilder(context, UserDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }
}
