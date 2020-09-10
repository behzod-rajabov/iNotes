package inotes.ic0der.uz

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import inotes.ic0der.uz.db.AppDB
import inotes.ic0der.uz.db.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    val mainModel = MutableLiveData<List<Note>>()
    val noteDao = AppDB.getInstance(application).noteDao()

    fun addNote(note: Note){
        GlobalScope.launch {
            noteDao.insertNote(note)
            val newData = noteDao.getAllNotes()
            GlobalScope.launch(Dispatchers.Main) {
                mainModel.value = newData
            }
        }
    }

    fun updateNote(note: Note){
        GlobalScope.launch {
            noteDao.updateNote(note)
            val newData = noteDao.getAllNotes()
            GlobalScope.launch(Dispatchers.Main) {
                mainModel.value = newData
            }
        }
    }

    fun deleteNote(note: Note){
        GlobalScope.launch {
            noteDao.deleteNote(note)
            val newData = noteDao.getAllNotes()
            GlobalScope.launch(Dispatchers.Main) {
                mainModel.value = newData
            }
        }
    }

    fun getAllNote(){
        GlobalScope.launch {
            val newData = noteDao.getAllNotes()
            GlobalScope.launch(Dispatchers.Main) {
                mainModel.value = newData
            }
        }
    }
}