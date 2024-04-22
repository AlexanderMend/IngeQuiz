package com.example.ingequiz.DataBase.Question

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionDao {

    @Query("SELECT * FROM questions")
    fun getQuestions(): Flow<List<Questions>>

    @Query("SELECT * FROM questions Where id=:id")
    fun getQuestionsById(id:Long): Flow<Questions>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: Questions)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateQuestion(question: Questions)

    @Delete
    suspend fun deleteQuestion(question: Questions)
}
