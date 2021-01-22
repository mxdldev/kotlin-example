package http

import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * Description: <RetrofitManager><br>
 * Author:      mxdl<br>
 * Date:        2021/1/22<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class RetrofitManager {
    companion object{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://v0.yiketianqi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
//Call的扩展函数一定要定义在顶级位置，否则调用不到
suspend fun <T> Call<T>.await1():T{
    return suspendCoroutine {
        enqueue(object :Callback<T>{
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if(response.isSuccessful){
                    val body = response.body()
                    if(body != null){
                        it.resume(body)
                    }else{
                        it.resumeWithException(Exception("body is null"))
                    }
                }else{
                    it.resumeWithException(HttpException(response))
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                it.resumeWithException(t)
            }

        })
    }
}