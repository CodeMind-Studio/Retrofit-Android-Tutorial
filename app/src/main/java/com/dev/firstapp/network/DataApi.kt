package com.dev.firstapp.network

import com.dev.firstapp.data.PostRequestModel
import com.dev.firstapp.data.PostResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface DataApi {
    @POST("post")
    suspend fun postData(@Body request: PostRequestModel): Response<PostResponseModel>

}