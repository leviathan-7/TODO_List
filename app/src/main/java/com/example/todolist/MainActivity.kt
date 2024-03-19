package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room.databaseBuilder
import com.example.todolist.Data.AppDatabase
import com.example.todolist.Data.AppRepository
import com.example.todolist.models.Note
import com.example.todolist.ui.theme.NotesViewModel
import com.example.todolist.ui.theme.TODOListTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = databaseBuilder(this, AppDatabase::class.java, "appdatabase").build()
        val repository = AppRepository(database.getNoteDao())
        notesViewModel = NotesViewModel(repository)

        setContent {
            TODOListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

var notesViewModel: NotesViewModel? = null
var buttonNote: Note? = null

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "NotesApp") {
        composable("NotesApp") {
            NotesApp(
                onNavigateToAdd = { navController.navigate("AddApp") },
                onNavigateToInf = { navController.navigate("InfApp") }
            )
        }
        composable("AddApp") { AddApp(onNavigateToNotes = { navController.navigate("NotesApp") }) }
        composable("InfApp") { InfApp(onNavigateToNotes = { navController.navigate("NotesApp") }, note = buttonNote!!) }
    }
}