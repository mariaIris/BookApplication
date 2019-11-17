package adapters

import android.content.Context
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapplication.R
import model.Book
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


class AdapterSwipe (var c: Context, var books:MutableList<Book>) : RecyclerView.Adapter<ViewHolderSwipe>(){
    private val PENDING_REMOVAL_TIMEOUT:Long = 3000 // 3sec
    var itemsPendingRemoval = ArrayList<Book>()

    private val handler = Handler()
    var pendingRunnables: HashMap<Book, Runnable> =
        HashMap()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSwipe {
        val view = LayoutInflater.from(c).inflate(R.layout.new_book_inflater, parent, false);

        return ViewHolderSwipe(view)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: ViewHolderSwipe, position: Int) {

        val escolhido = books[position]
        holder.textViewTitulo.text = escolhido.titulo
        holder.textViewNotaLivro.rating = escolhido.nota

        if (escolhido.bitten) {
            holder.imgLivro.setImageResource(R.drawable.book)
        } else {
            holder.imgLivro.setImageResource(R.drawable.book)
        }

        if (itemsPendingRemoval.contains(escolhido)) {
            holder.layoutNormal.setVisibility(View.GONE)
            holder.layoutGone.setVisibility(View.VISIBLE)
            holder.undoButton.setVisibility(View.VISIBLE)
            holder.undoButton.setOnClickListener {
                val pendingRemovalRunnable = pendingRunnables[escolhido]
                Log.i("", "CLIQUE")
                pendingRunnables.remove(escolhido)
                if (pendingRemovalRunnable != null) {
                    handler.removeCallbacks(pendingRemovalRunnable)
                }
                itemsPendingRemoval.remove(escolhido)
                notifyItemChanged(books.indexOf(escolhido))
            }
        } else {
            holder.textViewTitulo.setText(escolhido.titulo)
            holder.layoutNormal.setVisibility(View.VISIBLE)
            holder.layoutGone.setVisibility(View.GONE)
            holder.undoButton.setVisibility(View.GONE)
            holder.undoButton.setOnClickListener(null)
            if (escolhido.bitten) {
                holder.imgLivro.setImageResource(R.drawable.book)
            } else {
                holder.imgLivro.setImageResource(R.drawable.book)
            }

            holder.imgLivro.setOnClickListener{
                escolhido.bitten = true
                notifyItemChanged(position)
            }
        }


    }

    fun remover (position: Int){
        var livro = books[position]

        if (books.contains(livro)){
            books.removeAt(position)
            notifyItemRemoved(position)
        }
    }

   fun removerComTempo(position: Int) {

        val book = books[position]
        if (!itemsPendingRemoval.contains(book)) {
            itemsPendingRemoval.add(book)
            notifyItemChanged(position)
            var pendingRemovalRunnable = Runnable {
                remover(position)
            }
            handler.postDelayed(pendingRemovalRunnable, PENDING_REMOVAL_TIMEOUT)
            pendingRunnables[book] = pendingRemovalRunnable
        }
    }

    fun mover(fromPosition: Int, toPosition: Int) {

        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(books, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(books, i, i - 1)
            }
        }

        notifyItemMoved(fromPosition, toPosition)
        notifyItemChanged(toPosition)
        notifyItemChanged(fromPosition)
    }
}