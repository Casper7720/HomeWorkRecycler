package com.example.homeworkwithrecyclerview.info

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class Third1(
    private var title: String,
    private var secText: String,
    private var supportText: String,
) : RowType, Parcelable {
    fun getTitle(): Any {
        return title
    }

    fun getSecondText(): Any {
        return secText
    }

    fun getSupport(): Any {
        return supportText
    }
}