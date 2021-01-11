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
        val start = System.currentTimeMillis()
        var weather = async {
            service.getWeather1();
        }
        var air = async {
            service.air()
        }
        println(weather.await())
        println(air.await())
        val end = System.currentTimeMillis()
        println("w2:" + (end - start))
    }
    Thread.sleep(1000 * 5)
}