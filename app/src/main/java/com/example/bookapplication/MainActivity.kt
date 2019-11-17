package com.example.bookapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btCadastrar.setOnClickListener {
            startActivity(Intent(this, RegisterBook::class.java))
        }

        btListar.setOnClickListener {
            startActivity(Intent(this, ShowBook::class.java))
        }

       /* btBuscar.setOnClickListener {
            startActivity(Intent(this,ListBook::class.java))
        }*/

        btAutoComplete.setOnClickListener {
            startActivity(Intent(this,AutoComplete::class.java))
        }

        btListView.setOnClickListener {
            startActivity(Intent(this,ListBook::class.java))
        }

        btRecyclerView.setOnClickListener {
            startActivity(Intent(this,RecycleView::class.java))
        }

        btSwipeDragDrop.setOnClickListener {
            startActivity(Intent(this,DragDrop::class.java))
        }

        btPageView.setOnClickListener {
            startActivity(Intent(this,PageView::class.java))
        }

    }
}
