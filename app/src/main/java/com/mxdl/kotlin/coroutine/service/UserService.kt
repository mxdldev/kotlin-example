package com.mxdl.kotlin.coroutine.service

import com.mxdl.kotlin.coroutine.data.BaseResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("user/login/get")
    fun login(
        @Query("username") username: String,
        @Query("password") password: Int
    ): Call<BaseResponse>
}