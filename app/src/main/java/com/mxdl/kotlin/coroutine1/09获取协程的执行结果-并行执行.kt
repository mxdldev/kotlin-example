import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Description: <`09获取协程的执行结果-并行执行`><br>
 * Author:      mxdl<br>
 * Date:        2021/1/21<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    //await函数调用的位置不同，阻塞的位置就不同，挂起的位置就不同，完全由编程语言控制
    //如果在async函数之后直接调用await那么他就是串行的否则就是并行执行的
    runBlocking {
        val start = System.currentTimeMillis()
        val deferred1 = async {
            delay(1000 * 2)
            1 + 1
        }

        val deferred2 = async {
            delay(1000 * 3)
            2 + 2
        }

        println("result:"+(deferred1.await() + deferred2.await()))
        val end = System.currentTimeMillis()
        println("time:" + (end - start))
    }
}