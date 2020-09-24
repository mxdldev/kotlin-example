package com.mxdl.kotlin.dsl

import java.lang.StringBuilder

/**
 * Description: <HtmlV1><br>
 * Author:      mxdl<br>
 * Date:        2020/9/14<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
//利用DSL构建html
class Td {
    var content: String? = null
    fun html() = "\n\t\t<td>$content</td>"
}

class Tr {
    var tds = ArrayList<Td>()

    //DSL函数
    fun td(block: Td.() -> String) {
        var td = Td()
        td.content = td.block()
        tds.add(td)
    }

    fun html(): String {
        var stringBuilder = StringBuilder().apply {
            append("\n\t<tr>")
            for (td in tds) {
                append(td.html())
            }
            append("\n\t</tr>")
        }
        return stringBuilder.toString()
    }
}

class Table {
    var trs = ArrayList<Tr>()

    //DSL函数
    fun tr(block: Tr.() -> Unit) {
        var tr = Tr()
        tr.block()
        trs.add(tr)
    }

    fun html(): String {
        var stringBuilder = StringBuilder().apply {
            append("\n<table>")
            for (tr in trs) {
                append(tr.html())
            }
            append("\n</table>")
        }
        return stringBuilder.toString()
    }
}
//DSL函数
fun table(block: Table.() -> Unit): String {
    var table = Table()
    table.block()
    return table.html()
}

fun main(args: Array<String>) {
//    var tr = Tr()
//    tr.td { "a" }
//    tr.td { "b" }
//    println(tr.html())
//    var table = Table()
//    table.tr {
//        td { "a" }
//        td { "b" }
//    }
//    table.tr {
//        td { "c" }
//        td { "d" }
//    }
//    println(table.html())
   var table = table {
        tr {
            td { "a" }
            td { "b" }
            td { "c" }
        }
        tr {
            td { "a1" }
            td { "b1" }
            td { "c1" }
        }
    }
    println("table:$table")


}