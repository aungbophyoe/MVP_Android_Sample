package com.aungbophyoe.space.mvpandroidsample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aungbophyoe.space.mvpandroidsample.R
import com.aungbophyoe.space.mvpandroidsample.adapter.UserRecyclerAdapter
import com.aungbophyoe.space.mvpandroidsample.model.User
import com.aungbophyoe.space.mvpandroidsample.mvp.presenter.UserPresenter
import com.aungbophyoe.space.mvpandroidsample.mvp.presenter.UserPresenterImpl
import com.aungbophyoe.space.mvpandroidsample.mvp.view.UserView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(),UserView {
    private var userPresenter: UserPresenter? = null
    private val userRecyclerAdapter by lazy {
        UserRecyclerAdapter(this)
    }
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.rvUser)
    }

    private val progressBar : ProgressBar by lazy {
        findViewById(R.id.progressBar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = userRecyclerAdapter
        userPresenter = UserPresenterImpl(this)
        userPresenter?.loadData()
        progressBar.visibility = View.VISIBLE
    }

    override fun displayView(users: List<User>?) {
        Log.d("msg","success ${users?.size}")
        userRecyclerAdapter.submitList(users)
        recyclerView.adapter?.notifyDataSetChanged()
        progressBar.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }

    override fun displayError(msg: String?) {
        Log.d("msg","$msg")
        progressBar.visibility = View.GONE
        recyclerView.visibility = View.GONE
    }
}