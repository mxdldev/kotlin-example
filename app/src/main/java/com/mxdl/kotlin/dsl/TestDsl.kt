package com.mxdl.kotlin.dsl

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView

/**
 * Description: <TestDsl><br>
 * Author:      mxdl<br>
 * Date:        2020/9/14<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun TextView.addTextChangeListenerDsl(
    afterTextChanged: ((Editable?) -> Unit?)? = {},
    beforeTextChanged: ((CharSequence?, Int, Int, Int) -> Unit?)? = {_,_,_,_ -> Unit},
    onTextChanged: ((CharSequence?, Int, Int, Int) -> Unit)? = null
) {
    var textWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
           afterTextChanged?.invoke(p0)
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            beforeTextChanged?.invoke(p0,p1,p2,p3)
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            onTextChanged?.invoke(p0,p1,p2,p3)
        }
    }
    addTextChangedListener(textWatcher)
}
fun TextView.addTextChangeListenerDslV1(block:TextChangeListenerDslV2.()->Unit){
    var textChangeListenerDslV2 = TextChangeListenerDslV2()
    textChangeListenerDslV2.block()
    addTextChangedListener(textChangeListenerDslV2)
}
class TextChangeListenerDslV2:TextWatcher{
    var afterTextChanged: ((Editable?) -> Unit) ?= null
    var beforeTextChanged: ((CharSequence?, Int, Int, Int) -> Unit) ?= null
    var onTextChanged: ((CharSequence?, Int, Int, Int) -> Unit) ?= null
    //DSL方法
    fun afterTextChanged(block:(Editable?)-> Unit){
        afterTextChanged = block
    }
    fun beforeTextChanged(block: (CharSequence?, Int, Int, Int) -> Unit){
        beforeTextChanged = block
    }
    fun onTextChanged(block: (CharSequence?, Int, Int, Int) -> Unit){
        onTextChanged = block
    }

    override fun afterTextChanged(p0: Editable?) {
        afterTextChanged?.invoke(p0)
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        beforeTextChanged?.invoke(p0,p1,p2,p3)
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        onTextChanged?.invoke(p0,p1,p2,p3)
    }

}
fun main(args: Array<String>) {
    var textView: TextView? = null
    textView?.addTextChangeListenerDsl(onTextChanged = { a, b, c, d -> println(a)})
    textView?.addTextChangeListenerDslV1 {
        afterTextChanged {
            println(it.toString())
        }
        beforeTextChanged { charSequence, i, i2, i3 ->

        }
    }
}