package adapters

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapplication.R

class ViewHolderRecycle (v: View) : RecyclerView.ViewHolder(v){
    val textViewTitulo: TextView
    val textViewAutor: TextView
    val textViewNotaLivro: RatingBar
    val imgLivro: ImageView

    init {
        textViewTitulo = v.findViewById(R.id.tituloRecyle)
        textViewAutor = v.findViewById(R.id.autorRecycle)
        textViewNotaLivro = v.findViewById(R.id.notaRecycle)
        imgLivro = v.findViewById(R.id.imgRecycle)
    }
}