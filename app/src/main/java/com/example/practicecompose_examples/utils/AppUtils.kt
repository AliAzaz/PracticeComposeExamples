package com.example.practicecompose_examples.utils

import android.text.TextUtils
import androidx.compose.MutableState
import androidx.ui.input.TextFieldValue
import com.example.practicecompose_examples.model.Task
import com.example.practicecompose_examples.state.AppMain

fun addTask(taskText: Task) {
    AppMain.taskList.add(Task(taskText.title, taskText.message))
}

fun validateFields(
    titleText: MutableState<TextFieldValue>,
    taskText: MutableState<TextFieldValue>
): Boolean = !TextUtils.isEmpty(titleText.value.text) && !TextUtils.isEmpty(taskText.value.text)