package com.personal.animeshpandey.forgetnot20.Utils_Helpers

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun date_formatter(to_do_date:String){

    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
    val currentdatetime = LocalDateTime.now().format(formatter).toString()

    val currentdate = currentdatetime.substring(0..9)

}

fun time_formatter(to_do_time:String,to_do_date:String):String{

    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
    val currentdatetime = LocalDateTime.now().format(formatter).toString()
    val currenttime = currentdatetime.substring(11)


    if(to_do_date==currentdatetime.substring(0..9)){
        val current_hours = currenttime.substring(0..1).toInt()
        val toaccomplish_hours = to_do_time.substring(0..1).toInt()

        val hours_remaining = (toaccomplish_hours-current_hours)
        if(hours_remaining<0){
            println("Deadline Crossed")
            return "Deadline Crossed"
        }else{
            println(hours_remaining.toString())
            return "Less than "+hours_remaining.toString()+" Hours Remaining"
        }
    }
    else{
        println("More than A Day")
        return "More than A Day"
    }
}

fun main(){
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
    val currentdatetime = LocalDateTime.now().format(formatter).toString()
    val currenttime = currentdatetime.substring(11)

    time_formatter("08:00","09-03-2024")
}