package com.example.homeworkwithrecyclerview.info

data class First(val title : String,
                 val info : String
                 ) : RowType {


    fun getTitle(): Any {
        return title
    }

    fun getInfo(): Any{
        return info
    }
}