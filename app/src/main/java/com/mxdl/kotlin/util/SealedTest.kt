package com.mxdl.kotlin.util

/**
 * Description: <密封类><br>
 * Author:      mxdl<br>
 * Date:        2020/9/11<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
sealed class Result
class Success(val succ: String): Result()
class Failure(val error: Exception): Result()
fun getResult(result: Result){
   var result =  when(result){
        is Success -> result.succ
        is Failure -> result.error.message
    }
}
fun main(args: Array<String>) {

}
