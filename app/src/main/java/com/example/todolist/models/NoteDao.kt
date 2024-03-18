package com.example.todolist.models

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {
    @get:Query("SELECT * FROM note")
    val all: List<Note>

    @Query("SELECT * FROM note WHERE id = :id")
    fun getById(id: Long): Note

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)
}
