package ronell.composenotes.repository

import kotlinx.coroutines.flow.Flow
import ronell.composenotes.db.Note
import ronell.composenotes.db.NoteDao

class NoteRepository(private val dao: NoteDao) {
    val getNotes: Flow<List<Note>> = dao.getAllNotes()

    suspend fun insertNote(note: Note) = dao.insert(note)

    suspend fun updateNote(note: Note) = dao.update(note)

    suspend fun deleteNote(note: Note) = dao.delete(note)
}