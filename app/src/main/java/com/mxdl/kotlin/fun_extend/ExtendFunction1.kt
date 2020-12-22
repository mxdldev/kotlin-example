package com.mxdl.kotlin.fun_extend

import android.content.ContentValues
import android.content.SharedPreferences

/**
 * Description: <HeightLevelFunctionYY><br>
 * Author:      mxdl<br>
 * Date:        2020/9/11<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun SharedPreferences.open(block: SharedPreferences.Editor.() -> Unit) {
    var editor = edit()
    editor.block()
    editor.apply()
}

fun cvOf(vararg pairs: Pair<String, Any?>): ContentValues {
    var contentValues = ContentValues()
    for (pair in pairs) {
        val key = pair.first
        val value = pair.second
        when (value) {
            is Int -> contentValues.put(key, value)
            is String -> contentValues.put(key, value)
             null -> contentValues.putNull(key)
        }
    }
    return contentValues
}

fun main(args: Array<String>) {
    cvOf("key1" to 1, "key2" to "2")
}