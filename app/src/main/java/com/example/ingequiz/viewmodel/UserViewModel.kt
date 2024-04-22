package com.example.ingequiz.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ingequiz.DataBase.User.Users
import com.example.ingequiz.Repositorys.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UsersRepository): ViewModel(){
        private val _userList = MutableStateFlow<List<Users>>(emptyList())
    val userList = _userList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllusers().collect(){
                item ->
                if(item.isNullOrEmpty()){
                    _userList.value = emptyList()
                }else{
                    _userList.value = item
                }
            }
        }
    }

    fun addUser(user: Users) = viewModelScope.launch { repository.addUser(user) }
    fun updateUser(user: Users) = viewModelScope.launch { repository.updateUser(user) }
    fun deleteUser(user: Users) = viewModelScope.launch { repository.deleteUser(user) }
    }