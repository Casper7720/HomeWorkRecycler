package com.example.homeworkwithrecyclerview.info

import java.util.*

data class Second(private val name: String): RowType {
    fun getText(): Any {
        return name
    }

}