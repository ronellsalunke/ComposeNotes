package ronell.composenotes.ui.viewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ronell.composenotes.db.Note
import ronell.composenotes.repository.NoteRepository

class NoteViewModel(private val repository: NoteRepository) : ViewModel() {
    val allNotes: LiveData<List<Note>> = repository.getNotes.asLiveData()

    fun insertNote(note: Note) = viewModelScope.launch {
        repository.insertNote(note)
    }

    fun updateNote(note: Note) = viewModelScope.launch {
        repository.updateNote(note)
    }

    fun deleteNote(note: Note) = viewModelScope.launch {
        repository.deleteNote(note)
    }
}

class NoteViewModelFactory(private val repository: NoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NoteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}