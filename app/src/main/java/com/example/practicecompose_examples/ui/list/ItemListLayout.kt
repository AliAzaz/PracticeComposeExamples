package com.example.practicecompose_examples.ui.list

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.example.practicecompose_examples.R
import com.example.practicecompose_examples.model.Task
import com.example.practicecompose_examples.state.AppMain
import com.example.practicecompose_examples.state.MenuOptions
import com.example.practicecompose_examples.state.routingActivity

@Composable
private fun TaskViewItem(task: Task) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(10.dp).fillMaxWidth().heightIn(100.dp, 150.dp),
        elevation = 3.dp,
        content = {
            Box(
                modifier = Modifier.padding(13.dp),
                children = {
                    Row(Modifier.fillMaxSize(), children = {
                        Box(
                            gravity = Alignment.Center,
                            modifier = Modifier.wrapContentSize().fillMaxHeight(),
                            children = {
                                Stroke(4f)
                                Image(
                                    asset = imageResource(R.drawable.scene_01),
                                    modifier = Modifier.background(
                                        color = Color.Black,
                                        shape = CircleShape
                                    ).preferredSize(50.dp)
                                        .clip(CircleShape),
                                    contentScale = ContentScale.Crop
                                )
                            })
                        Column(
                            modifier = Modifier.padding(start = 15.dp, top = 5.dp, end = 15.dp)
                                .wrapContentSize(),
                            children = {
                                Text(
                                    task.title,
                                    modifier = Modifier.wrapContentHeight(),
                                    style = MaterialTheme.typography.h6
                                )
                                Text(
                                    task.message,
                                    modifier = Modifier.wrapContentHeight(),
                                    style = MaterialTheme.typography.body2
                                )
                            })

                        Box(
                            gravity = Alignment.CenterEnd,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Column(horizontalGravity = Alignment.CenterHorizontally, children = {
                                IconButton(
                                    onClick = {
                                        routingActivity(MenuOptions.ModifyTask(task))
                                    },
                                    icon = { Icon(asset = Icons.Filled.Edit) },
                                    modifier = Modifier.size(30.dp)
                                )
                                /*Spacer(modifier = Modifier.weight(0.5f))
                                IconButton(
                                    onClick = {
                                        deleteTask(task)
                                    },
                                    icon = { Icon(asset = Icons.Filled.Delete) },
                                    modifier = Modifier.size(30.dp)
                                )*/
                            })
                        }

                    })

                })
        })
}

@Composable
fun ItemList() {
    MaterialTheme {
        LazyColumnFor(items = AppMain.taskList, itemContent = { task ->
            TaskViewItem(task)
            Spacer(modifier = Modifier.padding(2.dp))
        })
    }
}