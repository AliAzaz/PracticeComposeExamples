package com.example.practicecompose_examples.ui.add

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.ColumnScope.weight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.practicecompose_examples.R
import com.example.practicecompose_examples.model.Task
import com.example.practicecompose_examples.state.MenuOptions
import com.example.practicecompose_examples.state.routingActivity
import com.example.practicecompose_examples.utils.addTask
import com.example.practicecompose_examples.utils.isTitleExist
import com.example.practicecompose_examples.utils.modifyTask
import com.example.practicecompose_examples.utils.validateFields

@Composable
fun AddTask(data: Task = Task("", "")) {
//    var title = remember { mutableStateOf(TextFieldValue(text = data.title)) }
    val title = remember { mutableStateOf(data.title) }
    val task = remember { mutableStateOf(data.message) }
    val titleExist = remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth().height(300.dp), children = {

        Row(
            modifier = Modifier.fillMaxWidth().height(250.dp).padding(10.dp),
            children = {
                Stroke(4f)
                Image(
                    asset = imageResource(R.drawable.scene_01),
                    modifier = Modifier.background(
                        color = Color.Black,
                        shape = CircleShape
                    ).padding(5.dp)
                        .preferredSize(50.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier.padding(5.dp).weight(2f)) {
                    if (titleExist.value) Text(
                        modifier = Modifier.padding(5.dp),
                        text = "Title already exist",
                        style = TextStyle(color = Color(0xFFF50B0B)) + MaterialTheme.typography.body1
                    )
                    Stack(modifier = Modifier.weight(2f)) {
                        if (data.title == "") TextField(
                            value = title.value,
                            onValueChange = { item ->
                                title.value = item
                                titleExist.value = isTitleExist(title)
                            },
                            label = {
                                Text(
                                    modifier = Modifier.padding(5.dp),
                                    text = "Title of Task",
                                    style = TextStyle(color = Color(0x77666666)) + MaterialTheme.typography.h6
                                )
                            },
                            modifier = Modifier.fillMaxWidth(),
                            textStyle = MaterialTheme.typography.h6,
                            backgroundColor = Color.White
                        ) else Text(
                            modifier = Modifier.padding(5.dp),
                            text = data.title,
                            style = TextStyle(color = Color(0x77666666)) + MaterialTheme.typography.h6
                        )
                    }
                    TextField(
                        value = task.value,
                        onValueChange = { item -> task.value = item },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(
                                modifier = Modifier.padding(5.dp),
                                text = "Add your Today's Task",
                                style = TextStyle(color = Color(0x77666666)) + MaterialTheme.typography.body1
                            )
                        },
                        textStyle = MaterialTheme.typography.body1,
                        backgroundColor = Color.White
                    )

                }

                CloseTaskScreen()
            })

        AddTaskBtn(titleExist, data, title, task)

    })

}


@Composable
private fun AddTaskBtn(
    titleExist: MutableState<Boolean>,
    prvTask: Task,
    titleText: MutableState<String>,
    taskText: MutableState<String>
) {
    val taskFlag = prvTask.title == ""
    Button(
        modifier = Modifier.padding(10.dp, 10.dp, 0.dp, 0.dp),
        backgroundColor =
        when {
            titleExist.value -> Color(0x77666666)
            !validateFields(
                titleText,
                taskText
            ) -> Color(0x77666666)
            else -> MaterialTheme.colors.primary
        },
        onClick = {
            when {
                titleExist.value -> return@Button
                !validateFields(titleText, taskText) -> return@Button
                taskFlag -> addTask(Task(titleText.value, taskText.value))
                else -> modifyTask(prvTask, Task(titleText.value, taskText.value))
            }
            routingActivity(MenuOptions.TaskList)
        },
        shape = RoundedCornerShape(20.dp),
        content = { Text(text = if (taskFlag) "Add Task" else "Modify Task", color = Color.White) }
    )
}

@Composable
private fun CloseTaskScreen() {
    IconButton(onClick = {
        routingActivity(MenuOptions.TaskList)
    }) {
        Icon(
            modifier = Modifier.size(30.dp).weight(1f),
            asset = Icons.Filled.Clear,
            tint = Color(0xFF656C70)
        )
    }
}



