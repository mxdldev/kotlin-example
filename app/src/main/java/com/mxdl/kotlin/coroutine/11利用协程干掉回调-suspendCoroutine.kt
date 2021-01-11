package com.mxdl.kotlin.coroutine

import com.mxdl.kotlin.coroutine.data.Weather
import com.mxdl.kotlin.coroutine.service.WeatherService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine
/**
 * Description: <RetrofitManager><br>
 * Author:      mxdl<br>
 * Date:        2020/9/27<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    //通过回调发起一个网络请求
    requestCallback()
    //通过协程发起一个网络请求
    requestCoroutine()
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

class RetrofitManager {
    companion object {
        var retrofit = Retrofit.Builder()
            //.baseUrl("http://192.168.33.150:8080/api/")
            .client(
                OkHttpClient().newBuilder()
                    /*.addInterceptor(
                        HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY)
                    )*/
                    .build()
            )
            .baseUrl("https://v0.yiketianqi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        inline fun <reified T> create() = retrofit.create(T::class.java)

    }
}
suspend fun <T> Call<T>.await(): T {
    return suspendCoroutine { continuation ->
        enqueue(object : Callback<T> {
            override fun onFailure(call: Call<T>, t: Throwable) {
                continuation.resumeWithException(t)
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                val body = response.body()
                if (body != null) {
                    continuation.resume(body)
                } else {
                    continuation.resumeWithException(Exception("body is null"))
                }
            }

        })
    }
}