package com.aungbophyoe.space.mvpandroidsample.mvp.presenter

import com.aungbophyoe.space.mvpandroidsample.model.User

interface UserPresenter {
    fun loadData()
    fun displayUserToView(users: List<User>?)
    fun displayErrorToView(msg:String?)
}