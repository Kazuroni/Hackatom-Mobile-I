// PessoasActivity.kt
package br.edu.fatecpg.ui.Views

import PessoaModel
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.ui.Adapter.PessoaAdapter
import br.edu.fatecpg.ui.R

class PessoasActivity : AppCompatActivity() {
    private lateinit var pessoasAdapter: PessoaAdapter
    private lateinit var listaPessoas: List<PessoaModel> // Defina a lista aqui

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pessoas) // Use o layout que contém o RecyclerView

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewPessoas)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Obtenha a lista de pessoas a partir do Intent
        val pessoas = intent.getParcelableArrayListExtra<PessoaModel>("PESSOAS_EXTRA") ?: emptyList()

        if (pessoas.isNotEmpty()) {
            pessoasAdapter = PessoaAdapter(pessoas)
            recyclerView.adapter = pessoasAdapter
        } else {
            Toast.makeText(this, "Nenhuma pessoa encontrada", Toast.LENGTH_SHORT).show()
        }
    }
}
