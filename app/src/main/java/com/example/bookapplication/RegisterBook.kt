package com.example.bookapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import dataBase.AppDataBase
import model.Book
import kotlinx.android.synthetic.main.activity_register_book.*


class RegisterBook : AppCompatActivity() {

    val db: AppDataBase by lazy {
        Room.databaseBuilder(
            this,
            AppDataBase::class.java,"database-pdm")
            .allowMainThreadQueries()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_book)

        buttonSalvar.setOnClickListener {
            salvarLivro()
        }

        buttonCancelar.setOnClickListener {
            finish()
        }
    }

    fun salvarLivro(){
       db.bookDao().inserir (
            Book(
                editTitulo.text.toString(),
                editAutor.text.toString(),
                editAno.text.toString().toInt(),
                ratingBar.rating,
                R.drawable.book1
            )
       )
     limpar()
    }

    fun limpar(){
        editTitulo.setText("")
        editAutor.setText("")
        editAno.setText("")
        ratingBar.rating = 0f
    }

}

