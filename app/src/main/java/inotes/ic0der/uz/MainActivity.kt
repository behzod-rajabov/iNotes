package inotes.ic0der.uz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        subscribe()
        getAllNote()
    }

    fun subscribe(){
        viewModel.mainModel.observe(this, Observer {

        })
    }

    fun addNote(){

    }

    fun updateNote(){

    }

    fun deleteNote(){

    }

    fun getAllNote(){
        viewModel.getAllNote()
    }
}