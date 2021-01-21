import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Description: <`08获取协程的执行结果-串行执行`><br>
 * Author:      mxdl<br>
 * Date:        2021/1/21<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    runBlocking {
        val start = System.currentTimeMillis()
        //1.使用async开启一个协程
        //2.async一旦调用它里面的代码就会立即执行
        //3.await方法会获取执行结果，如果async里面的代码或者子协程没有执行完毕，
        // 则await方法会一直阻塞，直到结果返回
        val result1 = async {
            delay(1000 * 3)
            1 + 1
        }.await()
        println("result1:"+result1)

        val result2 = async {
            delay(1000 * 2)
            2 + 2
        }.await()
        println("result2:"+result2)

        val end = System.currentTimeMillis()

        println("time:"+(end - start))

    }
}