package br.edu.fatecpg.ui.Adapter

import PessoaModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.ui.Holders.PessoaHolder
import br.edu.fatecpg.ui.R
import com.bumptech.glide.Glide

class PessoaAdapter(private val listaPessoas: List<PessoaModel>) : RecyclerView.Adapter<PessoaHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itempessoa, parent, false) // Corrija o nome aqui se necessário
        return PessoaHolder(view)
    }

    override fun onBindViewHolder(holder: PessoaHolder, position: Int) {
        val pessoa = listaPessoas[position]
        holder.Nome.text = pessoa.nome
        holder.Telefone.text = pessoa.telefone

        Glide.with(holder.Imagem.context)
            .load(pessoa.imagemUrl)
            .into(holder.Imagem)
    }

    override fun getItemCount(): Int = listaPessoas.size
}
