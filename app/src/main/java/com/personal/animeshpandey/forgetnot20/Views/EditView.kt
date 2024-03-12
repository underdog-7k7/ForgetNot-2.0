package com.personal.animeshpandey.forgetnot20.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.personal.animeshpandey.forgetnot20.ViewModel.TaskViewModel



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreen(id:Int,
               viewModel:TaskViewModel,
               navcontroller:NavController)
{

    val scrollstate = rememberScrollState()

    val snackMessage = remember{ mutableStateOf("") }

    val scope = rememberCoroutineScope()


    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.primaryContainer)
        .verticalScroll(scrollstate),) {

        Row(modifier = Modifier.fillMaxWidth()){
            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),text = "Add Details", color = MaterialTheme.colorScheme.primary, fontSize = 96.sp)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)){
            inputBoxTitle(viewModel._TaskTitle,{viewModel.updateTaskTitle(it)})
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(4.dp))

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)){
            inputBoxDescription(viewModel._TaskDescription,{viewModel.updateTaskDesc(it)})
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(4.dp))


        Row(modifier = Modifier.fillMaxWidth()){
            priorityselector(viewModel = viewModel)
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(4.dp))


        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), horizontalArrangement = Arrangement.Center){
            timePicker()
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(4.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Button(onClick = { /*TO ADD/EDIT AND THEN RETURN BACK TO TASK VIEW*/ }) {
                Text(text = "Submit")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun test3(){
    EditScreen(id=1,viewModel = viewModel(), navcontroller = rememberNavController())
}

