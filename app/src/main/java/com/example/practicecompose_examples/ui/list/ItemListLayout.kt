package com.example.practicecompose_examples.ui.list

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.drawscope.Stroke
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.material.IconButton
import androidx.ui.material.MaterialTheme
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.ArrowDropDown
import androidx.ui.res.imageResource
import androidx.ui.unit.dp
import com.example.practicecompose_examples.R
import com.example.practicecompose_examples.model.Task
import com.example.practicecompose_examples.state.AppMain
import com.example.practicecompose_examples.state.MenuOptions
import com.example.practicecompose_examples.state.routingActivity

@Composable
private fun cardViewItem(task: Task) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(10.dp)
            .fillMaxWidth(),
        elevation = 3.dp,
        content = {
            Box(
                modifier = Modifier.padding(13.dp),
                children = {

                    Row(modifier = Modifier.fillMaxSize(), children = {
                        Image(
                            asset = imageResource(R.drawable.scene_01),
                            modifier = Modifier.drawBackground(
                                color = Color.Black,
                                style = Stroke(4f),
                                shape = CircleShape
                            ).preferredSize(50.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            modifier = Modifier.padding(start = 15.dp, top = 5.dp, end = 15.dp),
                            children = {
                                Text(
                                    task.title.capitalize(),
                                    style = MaterialTheme.typography.h6
                                )
                                Text(
                                    task.message.capitalize(),
                                    style = MaterialTheme.typography.body2
                                )
                            })

                        Box(gravity = Alignment.CenterEnd, modifier = Modifier.fillMaxSize()) {
                            IconButton(onClick = {
                                routingActivity(MenuOptions.AddTask)
                            }) {
                                Icon(asset = Icons.Filled.ArrowDropDown)
                            }
                        }


                    })

                })
        })
}

@Composable
fun ItemList() {
    VerticalScroller {
        Column {
            AppMain.taskList.forEach { task ->
                cardViewItem(task)
                Spacer(modifier = Modifier.padding(2.dp))
            }
        }
    }
}