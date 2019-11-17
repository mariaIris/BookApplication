package com.example.bookapplication

import adapters.AdapterListView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import dataBase.AppDataBase
import kotlinx.android.synthetic.main.activity_list_book.*
import model.Book

class ListBook : AppCompatActivity() {

    val db: AppDataBase by lazy {
        Room.databaseBuilder(
            this,
            AppDataBase::class.java,"database-pdm")
            .allowMainThreadQueries()
            .build()
    }

    var books: List<Book>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_book)

        books = db.bookDao().listAll()
        listView.adapter=AdapterListView(this,books as List<Book>)
        listView.setOnItemClickListener { adapterView, view, i, id ->
            var selecionado=books?.get(i)
            Toast.makeText(this,"${selecionado?.titulo} id=${selecionado?.id}", Toast.LENGTH_SHORT).show()
        }
    }
}
