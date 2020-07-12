package com.example.practicecompose_examples.ui

import androidx.compose.Composable
import androidx.ui.foundation.Icon
import androidx.ui.material.FloatingActionButton
import androidx.ui.material.Scaffold
import androidx.ui.res.colorResource
import androidx.ui.res.vectorResource
import com.example.practicecompose_examples.R

@Composable
fun ScaffoldContent() {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                backgroundColor = colorResource(
                    id = R.color.purple_500
                )
            ) {
                Icon(asset = vectorResource(id = R.drawable.ic_note_add))
            }
        }
    ) {
        ItemLayoutList()
    }
}