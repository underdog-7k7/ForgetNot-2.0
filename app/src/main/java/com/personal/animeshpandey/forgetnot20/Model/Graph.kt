package com.personal.animeshpandey.forgetnot20.Model

import android.content.Context
import androidx.room.Room

object Graph {
    lateinit var database:TaskDataBase

    val task_repo by lazy{
        TaskRepository(taskdao = database.taskDAO())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context,TaskDataBase::class.java,"forgetnot_v2.db").build()
    }
}