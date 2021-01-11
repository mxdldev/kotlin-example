package com.mxdl.kotlin.fun_edit_text

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView

/**
 * Description: <TextChangeListenerLeval><br>
 * Author:      mxdl<br>
 * Date:        2021/1/3<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    var textView: TextView? = null
    textView?.addTextChangeListenerLeval(onTextChanged = { a, b, c, d -> println(a)})
}
fun TextView.addTextChangeListenerLeval(
    afterTextChanged: (p0: Editable?) -> Unit = {p0 ->},
    beforeTextChanged: (p0: CharSequence?, p1: Int, p2: Int, p3: Int) -> Unit = { p0, p1, p2, p3 -> },
    onTextChanged: (p0: CharSequence?, p1: Int, p2: Int, p3: Int) -> Unit = { p0, p1, p2, p3 -> }
) {

    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            afterTextChanged.invoke(p0)
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            beforeTextChanged.invoke(p0, p1, p2, p3)
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            onTextChanged.invoke(p0, p1, p2, p3)
        }

    })
}
