package com.personal.animeshpandey.forgetnot20

import android.app.Application
import com.personal.animeshpandey.forgetnot20.Model.Graph

class TaskApp:Application(){
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}