package com.aungbophyoe.space.mvpandroidsample.mvp.presenter

import com.aungbophyoe.space.mvpandroidsample.model.User
import com.aungbophyoe.space.mvpandroidsample.mvp.model.UserModel
import com.aungbophyoe.space.mvpandroidsample.mvp.view.UserView

class UserPresenterImpl : UserPresenter {
    var userView : UserView? = null
    constructor(userView_: UserView){
        this.userView = userView_
    }
    override fun loadData() {
        val userModel = UserModel()
        userModel.getData(this)
    }

    override fun displayUserToView(users: List<User>?) {
        userView?.displayView(users)
    }

    override fun displayErrorToView(msg: String?) {
        userView?.displayError(msg)
    }
}