package com.example.mvpexample.Presenter

import com.example.mvpexample.Model.User
import com.example.mvpexample.View.ILoginView

class LoginPresenter(internal val iLoginView: ILoginView) : ILoginPresenter{
    override fun onLogin(email: String, password: String) {
        val user = User(email, password)
        val loginCode = user.isDataValid()
        if(loginCode == 0)
            iLoginView.onLoginFail("이메일을 작성해주세요")
        else if(loginCode == 1)
            iLoginView.onLoginFail("잘못된 이메일 주소입니다")
        else if(loginCode == 2)
            iLoginView.onLoginFail("비밀번호를 6글자 이상 작성해주세요")
        else
            iLoginView.onLoginSuccess("로그인 성공")
    }
}