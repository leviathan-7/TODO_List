package com.example.todolist.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.todolist.models.Note;
import com.example.todolist.models.NoteDao;

@Database(entities = {Note.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NoteDao employeeDao();
}
