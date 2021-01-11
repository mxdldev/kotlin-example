package com.mxdl.kotlin.coroutine

import com.mxdl.kotlin.coroutine.data.Weather
import com.mxdl.kotlin.coroutine.service.WeatherService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Description: <Test><br>
 * Author:      mxdl<br>
 * Date:        2021/1/10<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://v0.yiketianqi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service = retrofit.create(WeatherService::class.java)

    val coroutineScope = CoroutineScope(Job());
    coroutineScope.launch {
        var weather = service.getWeather1();
        println(weather)
    }
    Thread.sleep(1000 * 5)
}

private fun test() {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://v0.yiketianqi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(WeatherService::class.java)
    service.getWeather().enqueue(object : Callback<Weather> {
        override fun onFailure(call: Call<Weather>, t: Throwable) {
            println(t.toString())
        }

        override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
            println(response.body().toString())
        }
    })
}
