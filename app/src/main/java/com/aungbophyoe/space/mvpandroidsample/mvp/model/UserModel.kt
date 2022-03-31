package com.aungbophyoe.space.mvpandroidsample.mvp.model

import android.util.Log
import com.aungbophyoe.space.mvpandroidsample.mvp.presenter.UserPresenter
import com.aungbophyoe.space.mvpandroidsample.network.ApiService
import com.aungbophyoe.space.mvpandroidsample.utils.AppConstants
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserModel{
    var api: ApiService
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(ApiService::class.java)
    }

    fun getData(userPresenter: UserPresenter){
        /*GlobalScope.launch {
            try {
                val response = api.getUsers()
                if(response.isSuccessful){
                    withContext(Dispatchers.Main){
                        userPresenter.displayUserToView(response?.body())
                    }
                }else{
                    withContext(Dispatchers.Main){
                        userPresenter.displayErrorToView("${response.message()}")
                    }
                }
            }catch (e:Exception){
                userPresenter.displayErrorToView("${e.message}")
            }
        }*/
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = api.getUsers()
                withContext(Dispatchers.Main){
                    if(response.isSuccessful){
                        userPresenter.displayUserToView(response?.body())
                    }else{
                        userPresenter.displayErrorToView("${response.message()}")
                    }
                }
            }catch (e:Exception){
                userPresenter.displayErrorToView("${e.message}")
            }
        }
    }
}