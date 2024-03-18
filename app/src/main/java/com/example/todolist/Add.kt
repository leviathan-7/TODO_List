package com.example.todolist

import android.database.Observable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.todolist.Data.Datasource
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.todolist.models.Note
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

@Composable
fun AddApp(modifier: Modifier = Modifier, onNavigateToNotes: () -> Unit) {
    val text = remember {mutableStateOf("")}
    val description = remember {mutableStateOf("")}

    LazyColumn(modifier = modifier){
        item {
            NavBar(text = "New",onNavigateToNotes = onNavigateToNotes)
        }
        item{
            Text(
                " Name:",
                fontSize = 25.sp,
                modifier = Modifier.fillMaxWidth(),
                color = Color.Blue
            )
        }
        item {
            TextField(
                value = text.value,
                onValueChange = { newText -> text.value = newText }
            )
        }
        item{
            Text(
                " Description:",
                fontSize = 25.sp,
                modifier = Modifier.fillMaxWidth(),
                color = Color.Blue
            )
        }
        item {
            TextField(
                value = description.value,
                onValueChange = { newText -> description.value = newText }
            )
        }
        item{
            Text(
                "",
                fontSize = 25.sp,
            )
        }
        item {
            Button(
                onClick = {
                    onNavigateToNotes()
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ){
                Text(
                    "ADD",
                    fontSize = 25.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


