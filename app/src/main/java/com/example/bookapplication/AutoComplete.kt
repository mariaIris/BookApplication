package com.example.bookapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.room.Room
import dataBase.AppDataBase
import kotlinx.android.synthetic.main.activity_auto_complete.*

class AutoComplete : AppCompatActivity() {

    val db:AppDataBase by lazy{
        Room.databaseBuilder(
            this,
            AppDataBase::class.java, "database - pdm")
            .allowMainThreadQueries()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_complete)

        var livros = db.bookDao().listAll()
        var titulos = Array<String>(livros.size,{i-> i.toString()})

        for(i in 0 until livros.size){
            titulos[i] = livros[i].titulo
        }

        var livroToAdapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, titulos)
        autcomplete.setAdapter(livroToAdapter)
        autcomplete.setOnItemClickListener { adapterView, view, i, id ->
            var selected = adapterView.getItemAtPosition(i)
            var livro = db.bookDao().findByName(selected.toString())
            textTitulo.text = livro.titulo
        }
    }
}
