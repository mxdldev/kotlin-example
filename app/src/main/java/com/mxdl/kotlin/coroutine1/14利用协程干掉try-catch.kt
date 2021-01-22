import kotlinx.coroutines.*

/**
 * Description: <`14利用协程干掉try-catch`><br>
 * Author:      mxdl<br>
 * Date:        2021/1/21<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    //testException()
    //main()
    //test1()
    test2()
    Thread.sleep(1000 * 5)
}

private fun test2() {
    runBlocking {

        val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println(throwable)
        }
        val coroutineScope = CoroutineScope(Job() + handler)
        coroutineScope.launch {
            launch {
                println("launcher1 start")
                delay(500)
                throw Exception("launcher1 e")
            }
            launch {
                delay(1000)
                println("launcher2 end")
                throw Exception("launcher2 e")
            }
            delay(1000)
            println("launcher end")
        }
        println("runBlocking end")
    }
}

private fun test1() {
    val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println(throwable)
    }
    runBlocking {
        supervisorScope {
            launch(handler) {
                println("launcher1 start")
                delay(500)
                throw Exception("launcher1 e")
            }
            launch(handler) {
                println("launcher2 start")
                delay(1000)
                throw Exception("launcher3 e")
            }
            println("launcher3 end")
        }
        println("runBlocking end")
    }
}

private fun testException() {
    //1.永远不要跨域捕获异常
    //2.利用CoroutineExceptionHandler可以简化异常捕获
    //3.CoroutineExceptionHanlder只能放在顶级协程
    val coroutineScope =
        CoroutineScope(Job() + CoroutineExceptionHandler { coroutineContext, throwable ->
            println(throwable)
        })
    coroutineScope.launch {
        launch {
            delay(500)
            throw Exception("Exception1")
        }
        launch {
            delay(200)
            throw Exception("Exception2")
        }
    }
}

