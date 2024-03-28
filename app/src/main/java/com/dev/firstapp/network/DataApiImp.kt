package com.dev.firstapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataApiImp {

    fun getDataApi(): DataApi =
        Retrofit.Builder().baseUrl("https://codemindstudio.in/retrofit/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(DataApi::class.java)
}