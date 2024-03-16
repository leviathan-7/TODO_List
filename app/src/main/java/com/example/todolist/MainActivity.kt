package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolist.ui.theme.TODOListTheme
import com.example.todolist.models.Note
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.example.todolist.Data.Datasource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TODOListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NotesApp()
                }
            }
        }
    }
}

@Composable
fun NoteCard(note: Note, modifier: Modifier = Modifier, checked: MutableState<Int>){
    Card(modifier = modifier, colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)) {
        Row {
            val isChecked = remember { mutableStateOf(note.isMade) }
            Checkbox(
                checked = isChecked.value,
                onCheckedChange = {
                    isChecked.value = it
                    note.isMade = !note.isMade
                    if (note.isMade){
                        checked.value++
                    }else{
                        checked.value--
                    }
                }
            )
            if (isChecked.value){
                Text(
                    text = note.text,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(6.dp),
                    style = TextStyle(textDecoration = TextDecoration.LineThrough)
                )
            }else{
                Text(
                    text = note.text,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(6.dp)
                )
            }
            Spacer(Modifier.weight(1f))
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.background)
                ){
                Text(
                    "\uD83D\uDDD1\uFE0F",
                    fontSize = 25.sp,
                )
            }
        }
    }
}

@Composable
fun NoteCardList(notesList: List<Note>, modifier: Modifier = Modifier, checked: MutableState<Int>) {
    val total = notesList.count()
    checked.value = notesList.count { note -> note.isMade }
    LazyColumn(modifier = modifier) {
        item{
            val text = "TODO list. Total = $total; Checked = ${checked.value} \n"
            Text(
                text,
                fontSize = 25.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.Blue
            )
        }
        items(notesList) { note ->
            NoteCard(
                note = note,
                modifier = Modifier.padding(10.dp),
                checked
            )
        }
        item {
            Button(
                onClick = {},
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

@Composable
fun NotesApp() {
    val checked = remember { mutableStateOf(0) }
    NoteCardList(
        notesList = Datasource().loadNotes(),
        checked = checked
    )

}

@Preview
@Composable
private fun NoteCardPreview() {
    val checked = remember { mutableStateOf(1) }
    NoteCard(note = Note("Make", true),checked = checked)
}