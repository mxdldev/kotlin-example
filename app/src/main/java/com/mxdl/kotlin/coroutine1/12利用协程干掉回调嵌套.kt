import bean.Air
import bean.Weather
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import service.WeatherService

/**
 * Description: <`12利用协程干掉回调嵌套`><br>
 * Author:      mxdl<br>
 * Date:        2021/1/21<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    //1.创建一个retrofit
    val retrofit = Retrofit.Builder()
        .baseUrl("https://v0.yiketianqi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    //2.创建一个天气服务
    val service = retrofit.create(WeatherService::class.java)

    val coroutineScope = CoroutineScope(Job())
    coroutineScope.launch {
        //1.获取天气
        val weather = async {
            service.getWeatherByCoroutine()
        }.await()
        println(weather)
        //2.获取空气质量
        val air = async {
            service.getAirByCoroutine()
        }.await()

        println(air)
    }
    Thread.sleep(1000 * 5)
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
            val call1  = service.getWeather()
            call1.enqueue(object:Callback<Weather>{
                override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                    TODO("Not yet implemented")
                }

                override fun onFailure(call: Call<Weather>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }

        override fun onFailure(call: Call<Weather>, t: Throwable) {
            println(t)
        }
    })
}