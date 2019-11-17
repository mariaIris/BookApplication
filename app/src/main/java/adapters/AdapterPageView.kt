package adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.bookapplication.R
import model.Book

class AdapterPageView (var context: Context, var books: List<Book>): BaseAdapter() {
    override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
        Log.i("HOLDER", "GetView invocado...")

        var holder: ViewHolderListView
        var view: View

        if (convertView == null){
            Log.i("HOLDER", "View Inflada")
            view = LayoutInflater.from(context).inflate(R.layout.book_inflater, p2, false)
            holder = ViewHolderListView(view)
            view.tag = holder
        }else{
            view = convertView
            holder  = convertView.tag as ViewHolderListView
        }

        var escolhido = books[position]
        holder.textViewTitulo.text = escolhido.titulo
        holder.textViewAutor.text = escolhido.autor
        holder.textViewNotaLivro.rating = escolhido.nota

        return view
    }

    override fun getItem(position: Int): Any {
        return books[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return  books.size
    }
}