package com.example.practicecompose_examples.model

import androidx.compose.getValue
import androidx.compose.mutableStateOf
import androidx.compose.setValue

class Task(title: String, message: String) {
    var title by mutableStateOf(title)
    var message by mutableStateOf(message)
}

