import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Description: <`05在普通函数启动一个协程`><br>
 * Author:      mxdl<br>
 * Date:        2021/1/20<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    runBlocking {
        login()
    }
}
//在普通函数中启动一个协程
//1.该函数必须是挂起函数
//2.调用协程内置api创建一个协程作用域
suspend fun login(){
    coroutineScope {
        launch {  }
    }
}