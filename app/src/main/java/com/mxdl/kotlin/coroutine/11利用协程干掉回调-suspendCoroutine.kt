package com.mxdl.kotlin.coroutine

import com.mxdl.kotlin.coroutine.data.Weather
import com.mxdl.kotlin.coroutine.http.RetrofitManager
import com.mxdl.kotlin.coroutine.http.await
import com.mxdl.kotlin.coroutine.service.WeatherService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
/**
 * Description: <RetrofitManager><br>
 * Author:      mxdl<br>
 * Date:        2020/9/27<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    //通过回调发起一个网络请求
    //requestCallback()
    //通过协程发起一个网络请求
    //requestCoroutine()

    requestAwait()

    Thread.sleep(1000 * 5)
}
//通过协程发起一个网络请求
private fun requestCoroutine() {
    val service = RetrofitManager.retrofit.create(WeatherService::class.java)
    val coroutineScope = CoroutineScope(Job());
    coroutineScope.launch {
        var weather = service.getWeather1();
        println(weather)
    }
}

//通过回调发起一个网络请求
private fun requestCallback() {
    val service = RetrofitManager.retrofit.create(WeatherService::class.java)
    service.getWeather().enqueue(object : Callback<Weather> {
        override fun onFailure(call: Call<Weather>, t: Throwable) {
            println(t.toString())
        }

        override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
            println(response.body().toString())
        }
    })
}

//通过回调发起一个网络请求
private fun requestAwait() {
    val service = RetrofitManager.retrofit.create(WeatherService::class.java)
    val coroutineScope = CoroutineScope(Job())
    coroutineScope.launch {
       val result = service.getWeather().await()
       println(result)
    }
}

