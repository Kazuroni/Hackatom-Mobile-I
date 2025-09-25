// MainActivity.kt
package br.edu.fatecpg.ui

import PessoaModel
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import br.edu.fatecpg.ui.Views.PessoasActivity
import com.google.android.material.textfield.TextInputEditText

private val pessoas = mutableListOf<PessoaModel>()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nomeInput = findViewById<TextInputEditText>(R.id.Nome)
        val telefoneInput = findViewById<TextInputEditText>(R.id.Telefone)
        val imagemInput = findViewById<TextInputEditText>(R.id.imagem)
        val adicionarButton = findViewById<Button>(R.id.BotaoRegistrar)

        adicionarButton.setOnClickListener {
            val nome = nomeInput.text.toString()
            val telefone = telefoneInput.text.toString()
            val imagemUrl = imagemInput.text.toString()

            if (nome.isNotEmpty() && telefone.isNotEmpty() && imagemUrl.isNotEmpty()) {
                val pessoa = PessoaModel(nome, telefone, imagemUrl)
                pessoas.add(pessoa)

                Toast.makeText(this, "A pessoa foi adicionada com sucesso.", Toast.LENGTH_LONG).show()

                // Limpa os campos após adicionar
                nomeInput.text?.clear()
                telefoneInput.text?.clear()
                imagemInput.text?.clear()
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }

        val verPessoasButton = findViewById<Button>(R.id.BotaoVerLista)
        verPessoasButton.setOnClickListener {
            val intent = Intent(this, PessoasActivity::class.java)
            intent.putParcelableArrayListExtra("PESSOAS_EXTRA", ArrayList(pessoas))
            startActivity(intent)
        }
    }
}
