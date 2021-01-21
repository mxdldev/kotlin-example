import bean.Weather
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import service.WeatherService

/**
 * Description: <`11利用协程干掉回调`><br>
 * Author:      mxdl<br>
 * Date:        2021/1/21<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    //requestWeatherCallback()
    getWeatherByCoroutine()
}

private fun getWeatherByCoroutine() {
    //1.创建一个retrofit
    val retrofit = Retrofit.Builder()
        .baseUrl("https://v0.yiketianqi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    //2.创建一个天气服务
    val service = retrofit.create(WeatherService::class.java)
    val coroutineScope = CoroutineScope(Job())
    //开启一个协程
    coroutineScope.launch {
        val result = service.getWeatherByCoroutine()
        println(result)
    }
    Thread.sleep(1000)
}

private fun requestWeatherCallback() {
    //1.创建一个retrofit
    val retrofit = Retrofit.Builder()
        .baseUrl("https://v0.yiketianqi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    //2.创建一个天气服务
    val service = retrofit.create(WeatherService::class.java)
    //3.创建一个请求天气的命令
    val call = service.getWeather()
    //4.发起请求
    call.enqueue(object : Callback<Weather> {
        override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
            println(response.body())
        }

        override fun onFailure(call: Call<Weather>, t: Throwable) {
            println(t)
        }
    })
}