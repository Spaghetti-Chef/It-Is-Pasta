package com.example.mvpexample.Model

interface IUser {
    val email: String
    val password: String
    fun isDataValid(): Int
}