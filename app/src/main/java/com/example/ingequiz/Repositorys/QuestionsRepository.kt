package com.example.ingequiz.Repositorys

import com.example.ingequiz.DataBase.Question.QuestionDao
import com.example.ingequiz.DataBase.Question.Questions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class QuestionsRepository@Inject constructor(private val questionDao: QuestionDao) {
    suspend fun addQuestion(question: Questions) = questionDao.insertQuestion(question = question)
    suspend fun updateQuestion(question: Questions) = questionDao.updateQuestion(question = question)
    suspend fun deleteQuestion(question: Questions) = questionDao.deleteQuestion(question = question)

    fun getAllquestions(): Flow<List<Questions>> = questionDao
        .getQuestions()
        .flowOn(Dispatchers.IO)
        .conflate()
    fun getQuestionById(id:Long):Flow<Questions> = questionDao
        .getQuestionsById(id)
        .flowOn(Dispatchers.IO)
        .conflate()
}