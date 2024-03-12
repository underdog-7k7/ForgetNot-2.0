package com.personal.animeshpandey.forgetnot20.Views

import android.text.Layout
import android.widget.TimePicker
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.personal.animeshpandey.forgetnot20.Model.Task
import com.personal.animeshpandey.forgetnot20.R
import com.personal.animeshpandey.forgetnot20.Utils_Helpers.time_formatter
import java.time.LocalDate
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import com.personal.animeshpandey.forgetnot20.ViewModel.TaskViewModel

@Composable
fun TaskItem(task: Task,onEdit:()->Unit){
    Card(modifier = Modifier
        .fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.primary)
        .padding(top = 8.dp, start = 8.dp, end = 8.dp))
    {


        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){

            Row(modifier = Modifier.weight(2f)){
                mainInfoBar(task = task,onEditButtonClicked = {onEdit()})
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
fun mainInfoBar( task:Task, onEditButtonClicked:()->Unit){

    var expanded by remember {
        mutableStateOf(true)
    }

    Column( verticalArrangement = Arrangement.SpaceEvenly) {
        Row{
            Text(modifier = Modifier.padding(8.dp), text = task.title, maxLines = 2)
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
            Button( onClick = {  }) {
                Icon(modifier = Modifier.size(16.dp),imageVector = Icons.Filled.Edit, contentDescription = "edit")
            }
            Button( onClick = {expanded=!expanded} //Show Description
            ){
                if(expanded==true){
                    Icon(modifier = Modifier.size(24.dp), imageVector = Icons.Filled.KeyboardArrowUp, contentDescription = "showmore",)
                }else{
                    Icon(modifier = Modifier.size(24.dp), imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = "showmore")
                }
            }
        }

        AnimatedVisibility(expanded) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)){
                Column(modifier = Modifier.padding(4.dp)) {
                    Row{
                        Text(text = "Details",  fontWeight = FontWeight.Bold )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row{
                        Text(stringResource(id = R.string.dummy_description))
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row{
                        Text(text = "Metrics", fontWeight = FontWeight.Bold)
                    }
                    Column {
                        Text(text =  time_formatter(task.time,task.date), fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun inputBoxTitle(value:String, onValueChange:(String)->Unit){
    OutlinedTextField(
        value = value, onValueChange = onValueChange, maxLines = 2,
        label = { Text(text = "Edit Task") },
        leadingIcon = {Icon(imageVector = Icons.Default.Edit, contentDescription = null)},
        shape = MaterialTheme.shapes.large
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun inputBoxDescription(value:String, onValueChange:(String)->Unit){
    OutlinedTextField(
        value = value, onValueChange = onValueChange,
        label = { Text(text = "Edit Description") },
        leadingIcon = {Icon(imageVector = Icons.Default.Edit, contentDescription = null)},
        shape = MaterialTheme.shapes.large
    )
}

@ExperimentalMaterial3Api
@Composable
fun timePicker(){
    val PickerState = rememberTimePickerState(10,20,is24Hour = true)

    var hours = PickerState.hour.toString()
    var minutes = PickerState.minute.toString()

    if(hours.length<2) hours = "0"+hours
    if(minutes.length<2) minutes = "0"+minutes

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
        TimePicker(state = PickerState)
    }

}

@Composable
fun priorityselector(viewModel: TaskViewModel){

    var priority by remember {
        mutableStateOf("High")
    }

    var clickedhigh by remember {
        mutableStateOf(false)
    }
    var clickedmed by remember {
        mutableStateOf(false)
    }
    var clickedlow by remember {
        mutableStateOf(false)
    }

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {

        Column( horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceAround) {
            Row{
                Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Color.Red)
                Text(text = "High")
            }
            RadioButton(selected = clickedhigh, onClick =
            {

                viewModel.updateTaskPriority("High".toString())
                clickedhigh=true
                clickedlow=false
                clickedmed=false

            })
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceAround) {
            Row{
                Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Color.Blue)
                Text(text = "Medium")
            }
            RadioButton(selected = clickedmed, onClick = {
                viewModel.updateTaskPriority("Medium".toString())
                clickedmed=true
                clickedhigh=false
                clickedlow=false
            })
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceAround) {
            Row{
                Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Color.Green)
                Text(text = "Low")
            }
            RadioButton(selected = clickedlow, onClick = {
                viewModel.updateTaskPriority("Low".toString())
                clickedlow= true
                clickedhigh=false
                clickedmed=false
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun tester(){
    TaskItem(task = Task(1,"Some big task that is supposed to be accomplished with high priority ","High","Some Description","09-03-2024","10:00 AM"),{  })
}

