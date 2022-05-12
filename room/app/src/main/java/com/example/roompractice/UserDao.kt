package com.example.roompractice

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(User: User): Long

    @Update
    suspend fun updateUser(User: User): Int

    @Delete
    suspend fun deleteUser(User: User): Int

    @Query("DELETE FROM user_data_table")
    suspend fun deleteAll(): Int

    @Query("SELECT * FROM user_data_table")
    fun getAllUser(): List<User>
}