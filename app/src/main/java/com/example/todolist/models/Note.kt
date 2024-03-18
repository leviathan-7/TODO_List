package com.example.todolist.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "text") val text: String,
    @ColumnInfo(name = "isMade") var isMade: Boolean,
    @ColumnInfo(name = "description") val description: String
)