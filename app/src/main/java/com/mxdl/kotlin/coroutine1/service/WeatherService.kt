package service

import bean.Air
import bean.Weather
import retrofit2.Call
import retrofit2.http.GET

/**
 * Description: <WeatherService><br>
 * Author:      mxdl<br>
 * Date:        2021/1/21<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
interface WeatherService {
    @GET("api?version=v61&appid=92286346&appsecret=fi5kztRL")
    fun getWeather(): Call<Weather>

    @GET("api?version=v61&appid=92286346&appsecret=fi5kztRL")
    suspend fun getWeatherByCoroutine(): Weather

    @GET("api?version=v10&appid=92286346&appsecret=fi5kztRL")
    suspend fun getAirByCoroutine(): Air
}