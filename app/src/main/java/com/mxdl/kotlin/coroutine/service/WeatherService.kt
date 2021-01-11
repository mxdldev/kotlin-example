package com.mxdl.kotlin.coroutine.service

import com.mxdl.kotlin.coroutine.data.Air
import com.mxdl.kotlin.coroutine.data.Weather
import retrofit2.Call
import retrofit2.http.GET

interface WeatherService {
    @GET("api?version=v61&appid=92286346&appsecret=fi5kztRL")
    fun getWeather(): Call<Weather>

    @GET("api?version=v61&appid=92286346&appsecret=fi5kztRL")
    suspend fun getWeather2(): Weather

    @GET("https://v0.yiketianqi.com/api?version=v10&appid=92286346&appsecret=fi5kztRL")
    suspend fun getAir(): Air
}