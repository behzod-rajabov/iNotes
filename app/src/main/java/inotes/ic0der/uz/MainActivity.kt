package inotes.ic0der.uz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import inotes.ic0der.uz.db.Note
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel
    lateinit var adapterNote: AdapterNote
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        adapterNote = AdapterNote{
            editTitle.setText(it.title, TextView.BufferType.EDITABLE)
            editDescription.setText(it.description,  TextView.BufferType.EDITABLE)
        }
        recycler.adapter = adapterNote
        subscribe()
        getAllNote()
        btn.setOnClickListener {
            if (editTitle.text.isNotEmpty() && editDescription.text.isNotEmpty()) {
                addNote(editTitle.text.toString(), editDescription.text.toString())
                editTitle.setText("", TextView.BufferType.EDITABLE)
                editDescription.setText("",  TextView.BufferType.EDITABLE)
            } else {
                Toast.makeText(this, "Barcha maydonlar to`ldirilishi shart!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun subscribe() {
        viewModel.mainModel.observe(this, Observer {
            adapterNote.setList(it)
        })
    }

    fun addNote(title: String, description: String) {
        val note = Note(System.currentTimeMillis(), title, description)
        viewModel.addNote(note)

    }

    fun updateNote() {

    }

    fun deleteNote() {

    }

    fun getAllNote() {
        viewModel.getAllNote()
    }
}