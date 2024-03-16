package com.example.todolist.Data

import com.example.todolist.models.Note

class Datasource {
    fun loadNotes(): List<Note> {
        return listOf<Note>(
            Note("андроид", false, "сделать задание по андроиду"),
            Note("ужин", false, "надо поужинать"),
            Note("пары", true, "сходить на пары"))
    }
}