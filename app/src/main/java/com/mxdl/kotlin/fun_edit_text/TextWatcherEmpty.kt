package com.mxdl.kotlin.fun_edit_text

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView

/**
 * Description: <EmptyTextWatcher><br>
 * Author:      mxdl<br>
 * Date:        2021/1/3<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
open class TextWatcherEmpty : TextWatcher {
    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }
}

fun main(args: Array<String>) {
    var textView: TextView? = null
    textView?.addTextChangedListener(object :
        TextWatcherEmpty(){
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            super.onTextChanged(s, start, before, count)
        }
    })


    textView?.addTextChangedListener(object :TextWatcher{
        override fun afterTextChanged(s: Editable?) {
            TODO("Not yet implemented")
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            TODO("Not yet implemented")
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            TODO("Not yet implemented")
        }

    })
}
