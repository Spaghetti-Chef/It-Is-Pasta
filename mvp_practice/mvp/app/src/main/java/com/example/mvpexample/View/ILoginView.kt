package com.example.mvpexample.View

interface ILoginView {
    fun onLoginSuccess(message: String)
    fun onLoginFail(message: String)
}