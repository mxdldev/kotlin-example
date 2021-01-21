import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Description: <`07取消一个协程`><br>
 * Author:      mxdl<br>
 * Date:        2021/1/20<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    val job = Job()
    //创建一个协程
    val coroutineScope = CoroutineScope(job)
    //启动协程
    coroutineScope.launch {
        delay(1000 * 3)
        println("hello world")
    }
    job.cancel()
    println("main game over")
    Thread.sleep(1000 * 5)
}