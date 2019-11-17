package com.example.bookapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.room.Room
import dataBase.AppDataBase
import kotlinx.android.synthetic.main.activity_show_book.*
import model.Book
import java.util.ArrayList

class ShowBook : AppCompatActivity() {

    val db: AppDataBase by lazy {
        Room.databaseBuilder(
            this,
            AppDataBase::class.java,"database-pdm")
            .allowMainThreadQueries()
            .build()
    }

    var books = ArrayList<Book>();
    var contador = 0;

    fun clear(){
        textTitulo.text="";
        textAutor.text="";
        textAnoLancamento.text="";
        textNota.text="";
    }

    fun btVisivel(){
        btProximo.visibility = View.VISIBLE
        btAnterior.visibility = View.VISIBLE
    }

    fun btInvisivel(){
        btProximo.visibility = View.INVISIBLE
        btAnterior.visibility = View.INVISIBLE
    }

    fun posicao(){
        if (contador + 1 >= books.size){
            btProximo.visibility = View.INVISIBLE;
        }else{
            btAnterior.visibility = View.VISIBLE;
        }

        if (contador -1 < 0){
            btAnterior.visibility = View.INVISIBLE;
        }
    }

    fun buscar(){
        if (books.size>0){
            textTitulo.text=books.get(contador).titulo
            textAutor.text=books.get(contador).autor
            textAnoLancamento.text=books.get(contador).ano.toString()
            textNota.text=books.get(contador).nota.toString()

            btVisivel();
            posicao();

        }else{
            btInvisivel();
            clear();
        }
    }

    fun listBooks(){
        books.clear()
        db.bookDao().listAll().forEach { books.add(it)
        }
        buscar();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_book)

        listBooks();

        btAnterior.setOnClickListener {
            contador--;
            buscar();
        }

        btProximo.setOnClickListener {
            contador++;
            buscar();
        }
    }

}
