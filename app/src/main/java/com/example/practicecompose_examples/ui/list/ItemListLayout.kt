package com.example.practicecompose_examples.ui.list

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.*
import androidx.ui.foundation.lazy.LazyColumnItems
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.drawscope.Stroke
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.material.IconButton
import androidx.ui.material.MaterialTheme
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Edit
import androidx.ui.res.imageResource
import androidx.ui.unit.dp
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
        LazyColumnItems(items = AppMain.taskList) { task ->
            TaskViewItem(task)
            Spacer(modifier = Modifier.padding(2.dp))
        }
    }
}