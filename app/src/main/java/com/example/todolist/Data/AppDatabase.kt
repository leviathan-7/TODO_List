package com.example.todolist.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todolist.models.Note

@Database(
    version = 1,
    entities = [Note::class]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao

}
