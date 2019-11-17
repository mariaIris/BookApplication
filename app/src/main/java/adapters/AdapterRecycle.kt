package adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapplication.R
import model.Book

class AdapterRecycle (var context: Context, var books: List<Book>) : RecyclerView.Adapter<ViewHolderRecycle>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderRecycle {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_card,parent,false)
        return ViewHolderRecycle(view)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: ViewHolderRecycle, position: Int) {
        val escolhido = books[position]
        holder.textViewTitulo.text = escolhido.titulo
        holder.textViewAutor.text = escolhido.autor
        holder.textViewNotaLivro.rating = escolhido.nota
        holder.imgLivro.setImageResource(escolhido.img)
    }
}