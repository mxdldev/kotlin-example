package com.mxdl.kotlin.coroutine

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
class RetrofitManager {
    companion object {
        var retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.33.150:8080/api/")
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