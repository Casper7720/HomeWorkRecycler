package com.example.homeworkwithrecyclerview.info

import kotlinx.android.parcel.Parcelize


@Parcelize
class Third1(
    private var title: String,
    private var secText: String,
    private var supportText: String,
) : RowType {
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