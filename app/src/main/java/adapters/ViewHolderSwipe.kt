package adapters

import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapplication.R

class ViewHolderSwipe (v: View) : RecyclerView.ViewHolder(v) {

    val textViewTitulo: TextView
    val textViewAutor: TextView
    val textViewNotaLivro: RatingBar
    val imgLivro: ImageView
    val layoutNormal: LinearLayout
    val layoutGone: LinearLayout
    val undoButton: Button

    init {
        Log.i("HOLDER", "Realizando buscas através do id")
        textViewTitulo = v.findViewById(R.id.tituloLivro)
        textViewAutor = v.findViewById(R.id.autorLivro)
        textViewNotaLivro = v.findViewById(R.id.notaLivro)
        imgLivro = v.findViewById(R.id.imgLivro)
        layoutNormal = v.findViewById(R.id.layout_normal)
        layoutGone = v.findViewById(R.id.layout_gone)
        undoButton= v.findViewById(R.id.undo_button)
    }
}