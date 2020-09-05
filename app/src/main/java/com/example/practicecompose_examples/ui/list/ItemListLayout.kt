package com.example.practicecompose_examples.ui.list

import androidx.compose.foundation.Box
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnForIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.WithConstraints
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicecompose_examples.R
import com.example.practicecompose_examples.model.Task
import com.example.practicecompose_examples.state.AppMain
import com.example.practicecompose_examples.utils.TitleRowBox
import com.example.practicecompose_examples.utils.addTask
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
private fun TaskViewItem(index: Int, task: Task) {
    WithConstraints(children = {
        Card(
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.padding(2.dp).fillMaxWidth().preferredHeight(110.dp).padding(5.dp)
            /*.swipeToDelete(
                    constraints = Constraints(110),
                    onDelete = { *//*deleteTask(index, task)*//* }),*/,
            elevation = 3.dp,
            content = {
                Surface(
                    modifier = Modifier.padding(13.dp),
                    content = {
                        Row(Modifier, children = {
                            AvatarImage(url = R.drawable.scene_01)
                            Column(
                                modifier = Modifier.padding(start = 15.dp, top = 5.dp, end = 15.dp),
                                children = {
                                    TitleRowBox {
                                        TitleRow(task = task)
                                    }
                                    Text(
                                        text = task.message,
                                        maxLines = 1,
                                        modifier = Modifier.preferredHeight(80.dp)
                                            .padding(0.dp, 5.dp, 0.dp, 0.dp),
                                        overflow = TextOverflow.Ellipsis,
                                        style = MaterialTheme.typography.body2
                                    )
                                })

                        })

                    })
            })
    })
}

@Composable
fun TitleRow(task: Task) {
    Text(
        text = task.title,
        maxLines = 1,
        modifier = Modifier,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.h6
    )
    Text(
        text = task.date,
        maxLines = 1,
        modifier = Modifier.wrapContentWidth(),
        overflow = TextOverflow.Ellipsis,
        style = TextStyle(fontSize = 12.sp, color = Color.Gray)
    )
    Icon(
        asset = Icons.Filled.ArrowRight,
        tint = Color.Gray
    )
}

@Composable
fun ItemList() {
    MaterialTheme {
        addTask(Task("Hello", "Test 12334567", "02/09/2020"))
        LazyColumnForIndexed(items = AppMain.taskList, itemContent = { index, task ->
            TaskViewItem(index, task)
            Spacer(modifier = Modifier.padding(2.dp))
        })
    }
}

@Composable
fun AvatarImage(url: Int) {
    Box(
        gravity = Alignment.Center,
        modifier = Modifier.fillMaxHeight(),
        children = {
            CoilImage(
                data = url, modifier = Modifier.border(3.dp, Color.Black, CircleShape)
                    .preferredSize(60.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        })
}