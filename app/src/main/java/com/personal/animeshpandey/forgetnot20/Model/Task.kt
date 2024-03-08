package com.personal.animeshpandey.forgetnot20.Model

import android.util.Log

data class Task(
    var ID:Int = 0 ,
    var title:String = "",
    var Priority:String = "",
    var Description:String = "",
    val date:String ="",
    val time:String = "",
){
    init {
        Log.d("DATA","Task Created")
    }
}


//dummy data

object dummytasks{
    val listoftasks =
        listOf<Task>(
            Task(1,"Some Task","High","Description about that very very important task","dd/mm/yyyy","00:00 PM"),
            Task(2,"Some Task","High","Description about that very very important task","dd/mm/yyyy","00:00 PM"),
            Task(3,"Some Task","High","Description about that very very important task","dd/mm/yyyy","00:00 PM")
        )
}





