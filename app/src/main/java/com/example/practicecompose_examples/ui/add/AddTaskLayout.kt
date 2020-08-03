package com.example.practicecompose_examples.ui.add

import androidx.compose.Composable
import androidx.compose.MutableState
import androidx.compose.state
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.drawscope.Stroke
import androidx.ui.input.TextFieldValue
import androidx.ui.layout.*
import androidx.ui.layout.RowScope.weight
import androidx.ui.material.Button
import androidx.ui.material.IconButton
import androidx.ui.material.MaterialTheme
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Clear
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
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
    val title = state { TextFieldValue(text = data.title) }
    val task = state { TextFieldValue(text = data.message) }
    val titleExist = state { false }

    Column(modifier = Modifier.fillMaxWidth().height(300.dp), children = {

        Row(
            modifier = Modifier.fillMaxWidth().height(250.dp).padding(10.dp),
            children = {
                Image(
                    asset = imageResource(R.drawable.scene_01),
                    modifier = Modifier.drawBackground(
                        color = Color.Black,
                        style = Stroke(4f),
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
                    Stack(Modifier.weight(1f)) {
                        TextField(
                            value = title.value,
                            onValueChange = {
                                title.value = it
                                titleExist.value = isTitleExist(data.title != "", title)
                            },
                            modifier = Modifier.fillMaxWidth().padding(5.dp),
                            textStyle = MaterialTheme.typography.h6
                        )
                        if (title.value.text.isEmpty()) Text(
                            modifier = Modifier.padding(5.dp),
                            text = "Title of Task",
                            style = TextStyle(color = Color(0x77666666)) + MaterialTheme.typography.h6
                        )
                    }
                    Stack(Modifier.weight(1f)) {
                        TextField(
                            value = task.value,
                            onValueChange = { task.value = it },
                            modifier = Modifier.fillMaxWidth().padding(5.dp),
                            textStyle = MaterialTheme.typography.body1
                        )
                        if (task.value.text.isEmpty()) Text(
                            modifier = Modifier.padding(5.dp),
                            text = "Add your Today's Task",
                            style = TextStyle(color = Color(0x77666666)) + MaterialTheme.typography.body1
                        )
                    }

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
    titleText: MutableState<TextFieldValue>,
    taskText: MutableState<TextFieldValue>
) {
    val taskFlag = prvTask.title == ""
    Button(
        modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp),
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
            if (titleExist.value) return@Button
            if (!validateFields(titleText, taskText)) return@Button
            if (taskFlag) addTask(Task(titleText.value.text, taskText.value.text))
            else modifyTask(prvTask, Task(titleText.value.text, taskText.value.text))
            routingActivity(MenuOptions.TaskList)
        },
        shape = RoundedCornerShape(20.dp),
        text = { Text(text = if (taskFlag) "Add Task" else "Modify Task", color = Color.White) }
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



