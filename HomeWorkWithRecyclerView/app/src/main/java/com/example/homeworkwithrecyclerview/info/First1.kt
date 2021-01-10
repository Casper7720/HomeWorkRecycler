package com.example.homeworkwithrecyclerview.info

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class First1(val title : String,
                  val info : String
) : RowType, Parcelable {



    fun getTitle(): Any {
        return title
    }

    fun getInfo(): Any{
        return info
    }

}