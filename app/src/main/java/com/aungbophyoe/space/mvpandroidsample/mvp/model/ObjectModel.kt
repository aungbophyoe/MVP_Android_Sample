package com.aungbophyoe.space.mvpandroidsample.mvp.model

import com.aungbophyoe.space.mvpandroidsample.utils.AppConstants.BASE_URL
import com.aungbophyoe.space.mvpandroidsample.network.ApiService
import com.aungbophyoe.space.mvpandroidsample.mvp.model.ObjectModel
import retrofit2.Retrofit
import com.aungbophyoe.space.mvpandroidsample.utils.AppConstants
import retrofit2.converter.gson.GsonConverterFactory

class ObjectModel private constructor() {
    var api: ApiService
    val data: Unit
        get() {}

    companion object {
        var instance: ObjectModel? = null
            get() {
                if (field == null) {
                    field = ObjectModel()
                }
                return field
            }
            private set
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(ApiService::class.java)
    }
}