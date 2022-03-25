package com.aungbophyoe.space.mvpandroidsample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aungbophyoe.space.mvpandroidsample.R
import com.aungbophyoe.space.mvpandroidsample.model.User
import com.aungbophyoe.space.mvpandroidsample.mvp.presenter.UserPresenter
import com.aungbophyoe.space.mvpandroidsample.mvp.presenter.UserPresenterImpl
import com.aungbophyoe.space.mvpandroidsample.mvp.view.UserView
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(),UserView {
    private var userPresenter: UserPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userPresenter = UserPresenterImpl(this)
        userPresenter?.loadData()
    }

    override fun displayView(users: List<User>?) {
        Log.d("msg","success ${users?.size}")
    }

    override fun displayError(msg: String?) {
        Log.d("msg","error")
    }
}