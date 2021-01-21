import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Description: <`04启动多个协程提升并发效率`><br>
 * Author:      mxdl<br>
 * Date:        2021/1/20<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    //testThread()
    //启动10万个协程打印一个小黑点
    testCoroutine()

}

private fun testCoroutine() {
    val start = System.currentTimeMillis()
    runBlocking {
        repeat(100000) {
            launch {
                println(".")
            }
        }
    }
    val end = System.currentTimeMillis()
    println("time:" + (end - start))
}

private fun testThread() {
    //启动10万个线程打印一个小黑点
    val start = System.currentTimeMillis()
    runBlocking {
        repeat(100000) {
            Thread({ println(".") }).start()
        }
    }
    val end = System.currentTimeMillis()
    println("time:" + (end - start))
}