package com.example.roompractice

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data_table")
data class User(
    var name: String,
    var email: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}

