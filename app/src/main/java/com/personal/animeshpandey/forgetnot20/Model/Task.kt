package com.personal.animeshpandey.forgetnot20.Model

import android.util.Log
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Task_Table")
data class Task(
    @PrimaryKey(autoGenerate = true) //automatically generate/increment primary key for the database
    var ID:Int = 0 ,
    @ColumnInfo(name = "Task Title", defaultValue = "Title")
    var title:String = "",
    @ColumnInfo(name = "Task Priority", defaultValue = "Priority of the task")
    var Priority:String = "",
    @ColumnInfo(name = "Task Description", defaultValue = "Description to be Added" )
    var Description:String = "",
    @ColumnInfo(name = "Task Date" )
    val date:String ="",
    @ColumnInfo(name = "Task Time")
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





