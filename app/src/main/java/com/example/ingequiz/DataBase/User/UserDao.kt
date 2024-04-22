package com.example.ingequiz.DataBase.User

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {

    @Query("SELECT * FROM users Where email = :email AND contraseña = :password")
    fun getUserByEmailAndPassword(email: String, password: String): Flow<Users>

    @Query("SELECT * FROM users")
    fun getUsers(): Flow<List<Users>>

    @Query("SELECT * FROM users Where id=:id")
    fun getUsersById(id:Long): Flow<Users>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: Users)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUser(user: Users)

    @Delete
    suspend fun deleteUser(user: Users)
}
