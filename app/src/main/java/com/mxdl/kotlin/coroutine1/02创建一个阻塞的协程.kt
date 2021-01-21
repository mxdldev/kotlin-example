import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Description: <`02创建一个阻塞的协程`><br>
 * Author:      mxdl<br>
 * Date:        2021/1/20<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    //1.runBlocking是一个顶级函数
    //2.创建一个阻塞的协程,runbolcking里面的所有代码和子协程执行完毕，才能继续往下执行
    //3.用于开发测试，正式项目中不用他
    runBlocking {
        println("hello world")
    }
    println("main game over")
}