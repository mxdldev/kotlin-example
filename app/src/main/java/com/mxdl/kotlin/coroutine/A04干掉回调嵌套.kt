package com.mxdl.kotlin.coroutine

import com.mxdl.kotlin.coroutine.service.WeatherService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun main(args: Array<String>) {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://v0.yiketianqi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(WeatherService::class.java)

    val coroutineScope = CoroutineScope(Job());
    coroutineScope.launch {
        var start = System.currentTimeMillis()
        var weather = async {
            service.getWeather1()
        }.await()
        println(weather)

        var air = async {
            service.air()
        }.await()
        println(air)
        var end = System.currentTimeMillis()
        println("time:" + (end - start))
    }
    Thread.sleep(1000 * 5)
}