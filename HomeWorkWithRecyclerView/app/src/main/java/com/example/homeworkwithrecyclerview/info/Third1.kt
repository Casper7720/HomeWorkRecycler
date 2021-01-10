package com.example.homeworkwithrecyclerview.info

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