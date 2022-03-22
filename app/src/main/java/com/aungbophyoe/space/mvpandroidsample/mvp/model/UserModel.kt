package com.aungbophyoe.space.mvpandroidsample.mvp.model

import com.aungbophyoe.space.mvpandroidsample.network.ApiService
import com.aungbophyoe.space.mvpandroidsample.utils.AppConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserModel private constructor(){
    var api: ApiService
    companion object{
        private var instance: UserModel? = null
            get() {
                if (instance == null) {
                    instance = UserModel()
                }
                return instance
            }
            private set
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(ApiService::class.java)
    }

    val data : Unit get(){}
}