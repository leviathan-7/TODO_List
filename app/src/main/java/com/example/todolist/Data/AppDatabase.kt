package com.example.todolist.Data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolist.models.Note

/*@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun employeeDao(): NoteDao?
}*/

@Database(
    version = 1,
    entities = [Note::class]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao
}
