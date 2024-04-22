package com.example.ingequiz.Repositorys

import com.example.ingequiz.DataBase.User.UserDao
import com.example.ingequiz.DataBase.User.Users
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UsersRepository@Inject constructor(private val userDao: UserDao) {
    suspend fun addUser( user: Users) = userDao.insertUser(user = user)
    suspend fun updateUser(user: Users) = userDao.updateUser(user = user)
    suspend fun deleteUser(user: Users) = userDao.deleteUser(user = user )

    fun getAllusers(): Flow<List<Users>> = userDao
        .getUsers()
        .flowOn(Dispatchers.IO)
        .conflate()

    fun getUserById(id:Long):Flow<Users> = userDao
        .getUsersById(id)
        .flowOn(Dispatchers.IO)
        .conflate()

    fun getUserByEmailPassword(email:String,password:String):Flow<Users> = userDao
        .getUserByEmailAndPassword(email, password)
        .flowOn(Dispatchers.IO)
        .conflate()
}