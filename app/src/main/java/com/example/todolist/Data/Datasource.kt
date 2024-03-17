package com.example.todolist.Data

import com.example.todolist.models.Note

class Datasource {
    fun loadNotes(): List<Note> {
        return listOf<Note>(
            Note(0, "андроид", false, "сделать задание по андроиду"),
            Note(1, "ужин", false, "надо поужинать"),
            Note(2, "пары", true, "сходить на пары"))
    }
}