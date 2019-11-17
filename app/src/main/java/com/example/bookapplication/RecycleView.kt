package com.example.bookapplication

import adapters.AdapterRecycle
import adapters.RecyclerViewClickListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import dataBase.AppDataBase
import kotlinx.android.synthetic.main.activity_recycle_view.*
import model.Book

class RecycleView : AppCompatActivity() {

    val db: AppDataBase by lazy {
        Room.databaseBuilder(
            this,
            AppDataBase::class.java, "database-pdm")
            .allowMainThreadQueries()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)
        var books:MutableList<Book> = db.bookDao().listAll()

        var adapter = AdapterRecycle(this, books)
        recyclerview.adapter = adapter

        val layout = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerview.layoutManager = layout

        recyclerview.addOnItemTouchListener(
            RecyclerViewClickListener(
                this,
                recyclerview,
                object :RecyclerViewClickListener.OnItemClickListener{
                    override fun onItemClick(view: View, position: Int) {
                        Toast.makeText(this@RecycleView, "Clique simples", Toast.LENGTH_SHORT)
                            .show()
                    }

                    override fun onItemLongClick(view: View, position: Int) {
                        val removida = books[position]
                        books.remove(removida)
                        recyclerview.adapter!!.notifyItemRemoved(position)
                        Toast.makeText(this@RecycleView, "Clique Logo", Toast.LENGTH_SHORT).show()
                        val snack = Snackbar.make(
                            recyclerview.parent as View, "Removido", Snackbar.LENGTH_LONG
                        )
                            .setAction("Cancelar") {
                               books.add(position, removida)
                                recyclerview.adapter!!.notifyItemInserted(position)
                            }
                        snack.show()

                    }
                })
        )

        recyclerview.itemAnimator = DefaultItemAnimator()
    }
}
