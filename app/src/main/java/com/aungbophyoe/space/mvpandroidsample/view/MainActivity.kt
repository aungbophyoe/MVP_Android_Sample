package com.aungbophyoe.space.mvpandroidsample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aungbophyoe.space.mvpandroidsample.R
import com.aungbophyoe.space.mvpandroidsample.adapter.UserRecyclerAdapter
import com.aungbophyoe.space.mvpandroidsample.model.User
import com.aungbophyoe.space.mvpandroidsample.mvp.presenter.UserPresenter
import com.aungbophyoe.space.mvpandroidsample.mvp.presenter.UserPresenterImpl
import com.aungbophyoe.space.mvpandroidsample.mvp.view.UserView
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(),UserView {
    private var userPresenter: UserPresenter? = null
    private val userRecyclerAdapter by lazy {
        UserRecyclerAdapter(this)
    }
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.rvUser)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = userRecyclerAdapter
        userPresenter = UserPresenterImpl(this)
        userPresenter?.loadData()
    }

    override fun displayView(users: List<User>?) {
        Log.d("msg","success ${users?.size}")
        userRecyclerAdapter.submitList(users)
        recyclerView.adapter?.notifyDataSetChanged()
    }

    override fun displayError(msg: String?) {
        Log.d("msg","error")
    }
}