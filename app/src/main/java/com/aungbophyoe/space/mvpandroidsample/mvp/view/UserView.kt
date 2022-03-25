package com.aungbophyoe.space.mvpandroidsample.mvp.view

import com.aungbophyoe.space.mvpandroidsample.model.User

interface UserView {
    fun displayView(users:List<User>?)
    fun displayError(msg:String?)
}