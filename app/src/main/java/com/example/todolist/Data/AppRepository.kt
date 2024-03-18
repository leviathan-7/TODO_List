package com.example.todolist.Data

import com.example.todolist.models.Note
import com.example.todolist.models.NoteDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppRepository(private val noteDao: NoteDao) {
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
    suspend fun getAll(): List<Note> {
        return withContext(Dispatchers.IO) {
            return@withContext noteDao.all
        }
    }
    suspend fun getById(id: Long): Note {
        return withContext(Dispatchers.IO) {
            return@withContext noteDao.getById(id)
        }
    }

}