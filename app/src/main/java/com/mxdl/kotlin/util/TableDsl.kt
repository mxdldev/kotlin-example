package com.mxdl.kotlin.util

import java.lang.StringBuilder

/**
 * Description: <TableDsl><br>
 * Author:      mxdl<br>
 * Date:        2020/9/6<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Td {
    var content = ""
    fun html() = "\n\t\t<td>$content</td>"
}

class Tr {
    var tds = ArrayList<Td>()
    fun td(block: Td.() -> String) {
        var td = Td()
        td.content = td.block()
        tds.add(td)
    }

    fun html(): String {
        var stringBuilder = StringBuilder()
        stringBuilder.append("\n\t<tr>")
        for (td in tds) {
            stringBuilder.append(td.html())
        }
        stringBuilder.append("\n\t</tr>")
        return stringBuilder.toString()
    }
}

class Table {
    var trs = ArrayList<Tr>()
    fun tr(block: Tr.() -> Unit) {
        var tr = Tr()
        tr.block()
        trs.add(tr)
    }

    fun html(): String {
        var stringBuilder = StringBuilder()
        stringBuilder.append("<table>")
        for (tr in trs) {
            stringBuilder.append(tr.html())
        }
        stringBuilder.append("\n<table>")
        return stringBuilder.toString()
    }
}

fun table(block: Table.() -> Unit): String {
    var table = Table()
    table.block()
    return table.html()
}

fun main(args: Array<String>) {
    var html = table {
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
    println("result:$html")
}