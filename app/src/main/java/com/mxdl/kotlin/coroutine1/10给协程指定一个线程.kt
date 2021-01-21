import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * Description: <`10给协程指定一个线程`><br>
 * Author:      mxdl<br>
 * Date:        2021/1/21<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    runBlocking {
        //Dispatchers.IO:IO线程任务多执行时间短
        //Dispatchers.Default:默认线程任务少执行时间长
        //Dispatchers.Main:UI主线程,Android中使用
        //withContext是async的精简版
        val result = withContext(Dispatchers.Default){
            delay(1000 * 2)
            println(Thread.currentThread().name)
            1 + 1
        }
        println(result)
    }
    println(Thread.currentThread().name)
}