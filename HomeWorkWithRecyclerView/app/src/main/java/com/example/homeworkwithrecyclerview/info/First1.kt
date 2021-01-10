package com.example.homeworkwithrecyclerview.info

import kotlinx.android.parcel.Parcelize

@Parcelize
class First1(val title : String,
             private val info : String
) : RowType {



    fun getTitle(): Any {
        return title
    }

    fun getInfo(): Any{
        return info
    }
}