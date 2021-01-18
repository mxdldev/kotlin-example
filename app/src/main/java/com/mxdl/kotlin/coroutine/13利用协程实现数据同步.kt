package com.mxdl.kotlin.coroutine

import com.mxdl.kotlin.coroutine.http.RetrofitManager
import com.mxdl.kotlin.coroutine.service.WeatherService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

fun main(args: Array<String>) {
    val service = RetrofitManager.retrofit.create(WeatherService::class.java)

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