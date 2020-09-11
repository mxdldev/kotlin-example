package com.mxdl.kotlin.util

import java.lang.StringBuilder

/**
 * Description: <HeightLevelFunction><br>
 * Author:      mxdl<br>
 * Date:        2020/9/11<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
inline fun num1AndNum211(num1: Int, num2: Int, noinline operation: (Int, Int) -> Int): Int {
    //内联的只能传递给内联的，非内联的可以传递给任意函数
    //那么可以使用noinline 强制排除，代码不用内联
    testAbc(operation)
    return operation(num1, num2)
}

inline fun num1AndNum212(num1: Int, num2: Int, crossinline operation: (Int, Int) -> Int): Int {
    //是内联函数，那么就意味着lambda表达式中可以使用return
    //但是该lambda又被另外一个标准的lambda所调用，则在其内部不能使用return
    //此时就冲突了，怎么办？可以使用crossinline关键字，强制要求被调用的lambda中不能有return
    var run = Runnable {
         operation(num1,num2)
    }
    return operation(num1, num2)
}

fun testAbc(block:(Int,Int) -> Int): Int{
    return block.invoke(1,2)
}
fun main(args: Array<String>) {
    //2.lambda表示调用
    val result3 = num1AndNum211(1, 2) {
            n1, n2 ->
        if(true){
           // return
        }
        n1 + n2
    }
    println("result3:$result3")
}