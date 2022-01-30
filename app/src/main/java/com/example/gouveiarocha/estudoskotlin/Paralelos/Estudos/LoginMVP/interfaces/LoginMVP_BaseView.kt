package com.example.loginmvp.interfaces

interface LoginMVP_BaseView<T> {
    var presenter: T
    fun bindViews()
}