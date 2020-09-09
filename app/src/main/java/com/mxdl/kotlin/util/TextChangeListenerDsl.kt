package com.mxdl.kotlin.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView

/**
 * Description: <TextChangeListenerDsl><br>
 * Author:      mxdl<br>
 * Date:        2020/9/6<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class TextChangeListenerDsl: TextWatcher {
    var afterTextChanged: ((Editable?) -> Unit)? = null;
    var beforeTextChanged: ((CharSequence?,Int,Int,Int) -> Unit)? = null
    var onTextChanged: ((CharSequence?,Int,Int,Int) -> Unit)? = null

    fun afterTextChanged(method:(Editable?) -> Unit){
        afterTextChanged = method
    }
    fun beforeTextChanged(method: (CharSequence?,Int,Int,Int) -> Unit){
        beforeTextChanged = method
    }
    fun onTextChanged(method: (CharSequence?,Int,Int,Int) -> Unit){
        onTextChanged = method
    }
    override fun afterTextChanged(p0: Editable?) {
        afterTextChanged?.invoke(p0)
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        beforeTextChanged?.invoke(p0, p1, p2, p3)
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        onTextChanged?.invoke(p0, p1, p2, p3)
    }
}

fun TextView.addTextChenageListenerDsl(block: TextChangeListenerDsl.()->Unit){
    var textChangeListenerDsl = TextChangeListenerDsl()
    textChangeListenerDsl.block()
    addTextChangedListener(textChangeListenerDsl)
}