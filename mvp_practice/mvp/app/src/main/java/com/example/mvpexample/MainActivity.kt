package com.example.mvpexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mvpexample.Presenter.ILoginPresenter
import com.example.mvpexample.Presenter.LoginPresenter
import com.example.mvpexample.View.ILoginView
import com.example.mvpexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ILoginView {
    private lateinit var binding: ActivityMainBinding

    internal lateinit var loginPresenter: ILoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Init
        loginPresenter = LoginPresenter(this)

        binding.btnLogin.setOnClickListener {
            loginPresenter.onLogin(binding.etEmail.text.toString(), binding.etPassword.text.toString())
        }
    }

    override fun onLoginSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginFail(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}