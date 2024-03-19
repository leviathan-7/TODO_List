package com.example.todolist

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.todolist.models.Note

@Composable
fun InfApp(modifier: Modifier = Modifier, onNavigateToNotes: () -> Unit, note: Note) {
    LazyColumn(modifier = modifier){
        item {
            NavBar(text = " Information", onNavigateToNotes = onNavigateToNotes)
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
            if (note.isMade) {
                Text(
                    text = " "+note.text,
                    fontSize = 25.sp,
                    style = TextStyle(textDecoration = TextDecoration.LineThrough)
                )
            } else {
                Text(
                    text = " "+note.text,
                    fontSize = 25.sp,
                )
            }
        }
        item{
            Text(
                "",
                fontSize = 25.sp,
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
        item{
            Text(
                " "+note.description,
                fontSize = 25.sp,
                modifier = Modifier.fillMaxWidth(),
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
                    "Go to list",
                    fontSize = 25.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

