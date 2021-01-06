package com.example.homeworkwithrecyclerview.info

class First1(val title : String,
                  val info : String
) : RowType {



    fun getTitle(): Any {
        return title
    }

    fun getInfo(): Any{
        return info
    }
}