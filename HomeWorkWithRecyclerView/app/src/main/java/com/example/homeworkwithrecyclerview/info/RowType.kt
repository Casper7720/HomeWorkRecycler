package com.example.homeworkwithrecyclerview.info

import android.os.Parcelable


interface RowType:Parcelable {


    val FIRST: Int
        get() = 0
    val SECOND: Int
        get() = 1
    val THIRD:Int
        get() = 2
}