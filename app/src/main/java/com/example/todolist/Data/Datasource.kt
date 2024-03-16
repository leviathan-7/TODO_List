package com.example.todolist.Data

import com.example.todolist.models.Note

class Datasource {
    fun loadNotes(): List<Note> {
        return listOf<Note>(
            Note("make android", false),
            Note("make android", false),
            Note("make android", true))
    }
}