import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Description: <`03启动多个协程`><br>
 * Author:      mxdl<br>
 * Date:        2021/1/20<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    //单线程模式下模拟多线程并发执行
    runBlocking {
        //启动一个子协程
        launch {
            println("launcher1 start")
            delay(1000)
            println("launcher1 end")
        }
        //创建第二个子协程
        launch {
            println("launcher2 start")
            delay(1000)
            println("launcher2 end")
        }
    }
}