package com.pdmtaller2.katyaherrera00188119.helpers

fun shortenText(text: String, maxLength: Int = 50): String {
    return if (text.length > maxLength) {
        text.substring(0, maxLength).trimEnd() + "..."
    } else {
        text
    }
}
