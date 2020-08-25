package com.example.practicecompose_examples.ui.list

import androidx.compose.foundation.Icon
import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import com.example.practicecompose_examples.R
import com.example.practicecompose_examples.state.MenuOptions
import com.example.practicecompose_examples.state.routingActivity

@Composable
fun FabAddTask() {
    FloatingActionButton(
        onClick = {
            routingActivity(MenuOptions.AddTask)
        },
        backgroundColor = colorResource(
            id = R.color.purple_200
        )
    ) { Icon(asset = vectorResource(id = R.drawable.ic_note_add), tint = Color.White) }
}