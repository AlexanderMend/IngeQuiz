package com.example.ingequiz.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ingequiz.DataBase.Question.Questions
import com.example.ingequiz.Repositorys.QuestionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(
    private val repository: QuestionsRepository): ViewModel() {
        private val _questionList = MutableStateFlow<List<Questions>>(emptyList())
    val questionList = _questionList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllquestions().collect(){
                item ->
                if(item.isNullOrEmpty()){
                    _questionList.value= emptyList()
                }else{
                    _questionList.value = item
                }
            }
        }
    }

    fun addQuestion(question : Questions) = viewModelScope.launch { repository.addQuestion(question) }
    fun updateQuestion(question : Questions) = viewModelScope.launch { repository.updateQuestion(question) }
    fun deleteQuestion(question : Questions) = viewModelScope.launch { repository.deleteQuestion(question) }


}