package com.mxdl.kotlin.util

/**
 * Description: <OperatorTest><br>
 * Author:      mxdl<br>
 * Date:        2020/9/11<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
//用运算符重载实现两个对象相加
class Money(val value: Int){
    operator fun plus(money: Money): Money{
        var sum = value + money.value
        return Money(sum)
    }

    operator fun plus(money: Int): Money{
        var sum = value + money
        return Money(sum)
    }
}

fun main(args: Array<String>) {
    var money1 = Money(10)
    var money2 = Money(23)
    var money3 = money1 + money2

    var money4 = money1 + 18

    println("money3:${money3.value}")
    println("money4:${money4.value}")
}