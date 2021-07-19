package ronell.composenotes

import android.app.Application
import ronell.composenotes.db.NoteDatabase
import ronell.composenotes.repository.NoteRepository

class NoteApplication : Application() {
    val noteDatabase by lazy { NoteDatabase.getInstance(this, applicationContext) }
    val repository by lazy { NoteRepository(noteDatabase.noteDao()) }
}
