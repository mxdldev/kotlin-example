package com.mxdl.kotlin.generic

/**
 * Description: <Transformer><br>
 * Author:      mxdl<br>
 * Date:        2020/9/24<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 *
 *     此时Transformer<Person>是Transformer<Student>的子类型，T只能出现in的位置上
 */
interface Transformer<in T> {
    fun transform(t: T): String

    //fun transform(name: String, age: Int): @UnsafeVariance T
}