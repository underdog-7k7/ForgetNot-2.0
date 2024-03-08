package com.personal.animeshpandey.forgetnot20.Views

import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.personal.animeshpandey.forgetnot20.Model.Task
import java.time.LocalDate

@Composable
fun TaskItem(task: Task){
    Card(modifier = Modifier
        .fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.primary)
        .padding(top = 8.dp, start = 8.dp, end = 8.dp))
    {

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){

            Row(modifier = Modifier.weight(2f)){
                mainInfoBar(task = task, onClickShowDesc = { /*TODO*/ }, onEditButtonClicked = {})
            }

            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically){
                date_time_priority( task = task)
            }
        }

    }
}

@Composable
fun date_time_priority(task:Task){

    val priority = task.Priority
    val date = task.date
    val time = task.time


    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        if(priority=="High"){
            Row(modifier = Modifier.padding(4.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(text = priority)
                Icon(imageVector = Icons.Filled.Star, contentDescription = "high priority", tint = Color.Red)
            }
        }

        if(priority=="Medium"){
            Row(modifier = Modifier.padding(4.dp),horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically) {
                Text(text = priority)
                Icon(imageVector = Icons.Filled.Star, contentDescription = "medium priority", tint = Color.Blue)
            }
        }

        if(priority=="Low"){
            Row(modifier = Modifier.padding(4.dp),horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically) {
                Text(text = priority)
                Icon(imageVector = Icons.Filled.Star, contentDescription = "Low priority", tint = Color.Green)
            }
        }

        //DATE DISPLAY
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Icon(imageVector = Icons.Filled.DateRange, contentDescription = null)
            val date = LocalDate.now().toString()
            Text(text = date)
        }

        //TIME DISPLAY
        Row(horizontalArrangement = Arrangement.SpaceBetween){
            Icon(imageVector = Icons.Filled.Notifications, contentDescription = null)
            Text(text = time)
        }
    }

}

@Composable
fun mainInfoBar( task:Task,onClickShowDesc:()->Unit, onEditButtonClicked:()->Unit){
    Column( verticalArrangement = Arrangement.SpaceEvenly) {
        Row{
            Text(modifier = Modifier.padding(8.dp), text = task.title, maxLines = 2)
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
            Button(modifier = Modifier.size(32.dp), onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Edit, contentDescription = "edit")
            }
            Button(modifier = Modifier.size(32.dp), onClick = { /*TODO*/ }) {
                Icon( imageVector = Icons.Filled.ArrowDropDown, contentDescription = "showmore")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun tester(){
    TaskItem(task = Task(1,"Some big task that is supposed to be accomplished with high priority ","High","Some Description","12/12/12","00:00 AM"),)
}