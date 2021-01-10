package com.example.homeworkwithrecyclerview.info

import kotlinx.android.parcel.Parcelize


@Parcelize
class Second1(private val name: String): RowType {
    fun getText(): Any {
        return name
    }
}