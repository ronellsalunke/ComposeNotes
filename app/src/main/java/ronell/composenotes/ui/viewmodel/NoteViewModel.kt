package ronell.composenotes.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import ronell.composenotes.db.Note
import ronell.composenotes.repository.NoteRepository
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    private val _allNotes = MutableStateFlow<List<Note>>(emptyList())
    val allNotes = _allNotes.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getNotes.distinctUntilChanged()
                .collect { notelist ->
                    if (notelist.isEmpty()) {
                        Log.d("Init", "empty note list")
                    } else {
                        _allNotes.value = notelist
                    }
                }
        }
    }

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