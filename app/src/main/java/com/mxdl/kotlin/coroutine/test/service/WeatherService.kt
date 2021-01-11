package com.mxdl.kotlin.coroutine.test.service

import com.mxdl.kotlin.coroutine.test.bean.Air
import com.mxdl.kotlin.coroutine.test.bean.Weather
import retrofit2.Call
import retrofit2.http.GET

/**
 * Description: <WeatherService><br>
 * Author:      mxdl<br>
 * Date:        2021/1/10<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
interface WeatherService {
    @GET("api?version=v61&appid=92286346&appsecret=fi5kztRL")
    fun getWeather() : Call<Weather>

    @GET("api?version=v61&appid=92286346&appsecret=fi5kztRL")
    suspend fun getWeather1() : Weather

    @GET("api?version=v10&appid=92286346&appsecret=fi5kztRL")
    suspend fun air() : Air
}