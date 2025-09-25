// PessoaHolder.kt
package br.edu.fatecpg.ui.Holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.ui.R

class PessoaHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val Nome: TextView = itemView.findViewById(R.id.nome) // Use o ID correto
    val Telefone: TextView = itemView.findViewById(R.id.telefone) // Use o ID correto
    val Imagem: ImageView = itemView.findViewById(R.id.imageview) // Use o ID correto
}
