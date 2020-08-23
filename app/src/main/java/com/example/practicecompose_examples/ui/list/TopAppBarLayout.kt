package com.example.practicecompose_examples.ui.list

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.practicecompose_examples.R

@Composable
fun TopBar() {
    TopAppBar(title = {
        Text(text = stringResource(id = R.string.app_name))
    }, actions = {
        IconButton(onClick = {
            /*Toast.makeText(
                ContextAmbient.current,
                "Swipe right items to delete",
                Toast.LENGTH_SHORT
            ).show()*/
        }, icon = {
            Icon(asset = Icons.Filled.Info)
        })
    })
}