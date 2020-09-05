package com.example.practicecompose_examples.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Task(title: String, message: String, date: String) {
    var title by mutableStateOf(title)
    var message by mutableStateOf(message)
    var date by mutableStateOf(date)
}

