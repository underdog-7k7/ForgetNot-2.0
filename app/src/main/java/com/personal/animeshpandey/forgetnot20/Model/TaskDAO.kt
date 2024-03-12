package com.personal.animeshpandey.forgetnot20.Model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
abstract class TaskDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addTask(task:Task)

    @Query("Select * from 'Task_Table'")
    abstract fun getAllTasks(): Flow<List<Task>>

    @Update
    abstract suspend fun updateTaskDetails(task:Task)

    @Delete
    abstract suspend fun deleteTask(task:Task)

    @Query("Select * from 'Task_Table' where id=:id")
    abstract fun getTaskById(id:Int):Flow<Task>
}