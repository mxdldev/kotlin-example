import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import service.WeatherService

/**
 * Description: <`13利用协程实现数据同步显示`><br>
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

    //3.创建一个协程
    val coroutineScope = CoroutineScope(Job())
    coroutineScope.launch {
        val weatherDeferred = async {
            service.getWeatherByCoroutine()
        }
        val airDeferred = async {
            service.getAirByCoroutine()
        }
        println(weatherDeferred.await())
        println(airDeferred.await())
    }
    Thread.sleep(1000 * 5)
}