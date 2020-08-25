package com.example.practicecompose_examples.ui.list

import android.widget.Toast
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.res.stringResource
import com.example.practicecompose_examples.R

@Composable
fun TopBar() {
    val flag = remember { mutableStateOf(false) }
    TopAppBar(title = {
        Text(text = stringResource(id = R.string.app_name))
    }, actions = {
        IconButton(onClick = {
            flag.value = true
        }, icon = {
            Icon(asset = Icons.Filled.Info)
        })
    })

    if (flag.value) {
        Toast.makeText(
            ContextAmbient.current,
            "Swipe items right to delete",
            Toast.LENGTH_LONG
        ).show()
    }
}