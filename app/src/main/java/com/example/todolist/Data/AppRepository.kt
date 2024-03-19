package com.example.todolist.Data

import androidx.lifecycle.LiveData
import com.example.todolist.models.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class AppRepository(private val noteDao: NoteDao) {
    fun getAll(): Flow<List<Note>> {
        return noteDao.all
    }
    suspend fun insert(note: Note) {
        withContext(Dispatchers.IO) {
            noteDao.insert(note)
        }
    }

    suspend fun update(note: Note) {
        withContext(Dispatchers.IO) {
            noteDao.update(note)
        }
    }
    suspend fun delete(note: Note) {
        withContext(Dispatchers.IO) {
            noteDao.delete(note)
        }
    }

    suspend fun getById(id: Long): Note {
        return withContext(Dispatchers.IO) {
            return@withContext noteDao.getById(id)
        }
    }

}