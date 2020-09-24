package com.mxdl.kotlin.generic

/**
 * Description: <SimpleData><br>
 * Author:      mxdl<br>
 * Date:        2020/9/24<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 *
 *     此时SimpleData<Student>是SimpleData<Person>的子类型，T只能出现在out的位置上
 */
class SimpleData<out T>(val t:T) {
//    var t:@UnsafeVariance T? = null
//    fun set(t: @UnsafeVariance T) {
//        this.t = t;
//    }

    fun get(): T? {
        return t
    }
}