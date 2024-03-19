package com.example.todolist.ui.theme
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.example.todolist.Data.AppRepository
import com.example.todolist.models.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class NotesViewModel( private val appRepository: AppRepository ) : ViewModel() {
    val notes: LiveData<List<Note>> = appRepository.getAll().asLiveData()
    fun insert(note: Note) = viewModelScope.launch {
        appRepository.insert(note)
    }
    fun delete(note: Note) = viewModelScope.launch {
        appRepository.delete(note)
    }
}

