package model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "livro")
data class Book(
    @ColumnInfo(name = "titulo")
    var titulo:String,
    @ColumnInfo(name = "autor")
    var autor: String,
    @ColumnInfo(name = "ano")
    var ano: Int,
    @ColumnInfo(name = "nota")
    var nota: Float,
    var img: Int) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var bitten: Boolean = false
}