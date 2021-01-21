import kotlinx.coroutines.*

/**
 * Description: <`14利用协程干掉try-catch`><br>
 * Author:      mxdl<br>
 * Date:        2021/1/21<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    //1.永远不要跨域捕获异常
    //2.利用CoroutineExceptionHandler可以简化异常捕获
    //3.CoroutineExceptionHanlder只能放在顶级协程
    val coroutineScope = CoroutineScope(Job() + CoroutineExceptionHandler { coroutineContext, throwable ->
        println(throwable)
    })
    coroutineScope.launch {
        try {
            launch {
                delay(500)
                throw Exception("Exception1")
            }
            launch {
                delay(200)
                throw Exception("Exception2")
            }
        } catch (e: Exception) {
            println(1)
        }
    }
    Thread.sleep(1000 * 5)
}