package dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import dao.BookDao
import model.Book

@Database(entities = [Book::class], version = 1)
abstract  class AppDataBase: RoomDatabase(){
    abstract  fun bookDao():BookDao
}