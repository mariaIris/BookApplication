package adapters

import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import com.example.bookapplication.R

class ViewHolderListView(v: View){
    val textViewTitulo: TextView
    val textViewAutor: TextView
    val textViewNotaLivro: RatingBar

    init {
        textViewTitulo = v.findViewById(R.id.tituloLivro)
        textViewAutor = v.findViewById(R.id.autorLivro)
        textViewNotaLivro = v.findViewById(R.id.notaLivro)
    }
}