package dao

import androidx.room.*
import model.Book

@Dao
interface BookDao {
    @Insert
    fun inserir(livro : Book): Long

    @Delete
    fun deletar(livro : Book): Int

    @Update
    fun atualizar(livro : Book): Int

    @Query("SELECT * FROM livro")
    fun listAll(): MutableList<Book>

    @Query("SELECT * FROM livro WHERE id = :id")
    fun findById(id: Long): Book

    @Query("SELECT * FROM livro WHERE titulo = :titulo")
    fun findByName (titulo: String) : Book
}
