import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Description: <`06阻塞一个协程`><br>
 * Author:      mxdl<br>
 * Date:        2021/1/20<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    runBlocking {
        launch {
            delay(200)
            println("launcher end")
        }
        coroutineScope {
            launch {
                delay(500)
                println("coroutineScope launcher end")
            }
            delay(100)
            println("coroutineScope end")
        }
        println("runBlocking end")
    }
}