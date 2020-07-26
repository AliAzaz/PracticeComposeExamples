package com.example.practicecompose_examples.ui.add

import androidx.compose.Composable
import androidx.compose.MutableState
import androidx.compose.state
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.TextField
import androidx.ui.foundation.drawBackground
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.drawscope.Stroke
import androidx.ui.input.TextFieldValue
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import com.example.practicecompose_examples.R
import com.example.practicecompose_examples.model.Task
import com.example.practicecompose_examples.state.MenuOptions
import com.example.practicecompose_examples.state.routingActivity
import com.example.practicecompose_examples.utils.addTask
import com.example.practicecompose_examples.utils.validateFields

@Composable
fun AddTask() {
    val title = state { TextFieldValue(text = "") }
    val task = state { TextFieldValue(text = "") }

    Column(modifier = Modifier.fillMaxWidth().height(300.dp), children = {

        Row(modifier = Modifier.fillMaxWidth().height(250.dp).padding(10.dp),
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

                Column(modifier = Modifier.padding(5.dp)) {
                    Stack {
                        TextField(
                            value = title.value,
                            onValueChange = { textFieldValue -> title.value = textFieldValue },
                            modifier = Modifier.fillMaxWidth().height(10.dp).padding(5.dp),
                            textStyle = MaterialTheme.typography.h6
                        )
                        if (title.value.text.isEmpty()) Text(
                            modifier = Modifier.padding(5.dp),
                            text = "Title",
                            style = TextStyle(color = Color(0x77666666)) + MaterialTheme.typography.h6
                        )
                    }
                    Stack {
                        TextField(
                            value = task.value,
                            onValueChange = { textFieldValue -> task.value = textFieldValue },
                            modifier = Modifier.fillMaxWidth().height(100.dp).padding(5.dp),
                            textStyle = MaterialTheme.typography.body1
                        )
                        if (task.value.text.isEmpty()) Text(
                            modifier = Modifier.padding(5.dp),
                            text = "Add your Today's Task",
                            style = TextStyle(color = Color(0x77666666)) + MaterialTheme.typography.body1
                        )
                    }

                }

            })

        AddTaskBtn(title, task)

    })

}


@Composable
private fun AddTaskBtn(
    titleText: MutableState<TextFieldValue>,
    taskText: MutableState<TextFieldValue>
) {
    Button(
        modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp),
        backgroundColor =
        if (!validateFields(
                titleText,
                taskText
            )
        ) Color(0x77666666) else MaterialTheme.colors.primary,
        onClick = {
            if (!validateFields(titleText, taskText)) return@Button
            addTask(Task(titleText.value.text, taskText.value.text))
            routingActivity(MenuOptions.TaskList)
        },
        shape = RoundedCornerShape(20.dp),
        text = { Text(text = "Add Task", color = Color.White) }
    )
}



