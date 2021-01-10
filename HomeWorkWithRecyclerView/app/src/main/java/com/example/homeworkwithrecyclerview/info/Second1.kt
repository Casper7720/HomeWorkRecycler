package com.example.homeworkwithrecyclerview.info

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class Second1(private val name: String): RowType, Parcelable {
    fun getText(): Any {
        return name
    }
}