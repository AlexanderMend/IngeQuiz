package com.example.ingequiz.di

import android.content.Context
import androidx.room.Room
import com.example.ingequiz.DataBase.Question.QuestionDao
import com.example.ingequiz.DataBase.Question.QuestionDatabase
import com.example.ingequiz.DataBase.User.UserDao
import com.example.ingequiz.DataBase.User.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesUserDao(userDatabase: UserDatabase):UserDao{
        return userDatabase.userDao()
    }

    @Singleton
    @Provides
    fun providesUserDataBase(@ApplicationContext context: Context):UserDatabase{
        return Room.databaseBuilder(
            context=context,
            UserDatabase::class.java,
            name = "users_db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesQuestionDao(questionDataBase: QuestionDatabase):QuestionDao{
        return questionDataBase.questionDao()
    }

    @Singleton
    @Provides
    fun providesQuestionDataBase(@ApplicationContext context: Context):QuestionDatabase{
        return Room.databaseBuilder(
            context = context,
            QuestionDatabase::class.java,
            name = "question_db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}