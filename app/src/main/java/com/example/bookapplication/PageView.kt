package com.example.bookapplication

import adapters.AdapterPageView
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import androidx.viewpager.widget.ViewPager
import dataBase.AppDataBase
import kotlinx.android.synthetic.main.activity_page_view.*

class PageView : AppCompatActivity() {
    val db: AppDataBase by lazy {
        Room.databaseBuilder(
            this,
            AppDataBase::class.java, "database-pdm")
            .allowMainThreadQueries()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_view)

        var listBooks = db.bookDao().listAll()

        viewpager.adapter = AdapterPageView(this, listBooks);
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{

            override fun onPageScrollStateChanged(state: Int) {
                Log.i("AULA17", "onPageScrollStateChanged");
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                Log.i("AULA17", "onPageScrolled chamado, posição: "+position);
            }

            override fun onPageSelected(position: Int) {
                Log.i("AULA17", "onPageSelected chamado, posição: "+position);
            }

        })
    }
}