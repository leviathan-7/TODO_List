package com.example.todolist.Data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todolist.models.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @get:Query("SELECT * FROM note")
    val all: Flow<List<Note>>

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getById(id: Long): Note

    @Insert
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)
}
