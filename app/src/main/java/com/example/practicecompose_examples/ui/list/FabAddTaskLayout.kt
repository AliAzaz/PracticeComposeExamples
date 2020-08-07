package com.example.practicecompose_examples.ui.list

import androidx.compose.Composable
import androidx.ui.foundation.Icon
import androidx.ui.material.FloatingActionButton
import androidx.ui.res.colorResource
import androidx.ui.res.vectorResource
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
            id = R.color.teel_200
        )
    ) { Icon(asset = vectorResource(id = R.drawable.ic_note_add)) }
}