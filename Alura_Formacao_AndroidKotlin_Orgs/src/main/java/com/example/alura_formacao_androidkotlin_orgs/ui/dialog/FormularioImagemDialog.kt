package com.example.alura_formacao_androidkotlin_orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.alura_formacao_androidkotlin_orgs.databinding.FormularioImagemBinding
import com.example.alura_formacao_androidkotlin_orgs.utils.extensions.tentaCarregarImagem
import com.example.alura_formacao_androidkotlin_orgs.utils.contants.Constants

class FormularioImagemDialog(private val context: Context) {

    fun mostra(
        urlDefault: String? = null,
        quandoImgCarregada: (img: String) -> Unit
    ) {

        // Trocando a implementação abaixo, onde criamos uma variavel 'binding' como referencia
        // da nossa view, vamos implementar uma função de escopo com o apply, dessa forma, deixamos
        // o apply recebe uma instancia do binding como um receiver
        // impl antiga -> val binding = FormularioImagemBinding.inflate(LayoutInflater.from(context)) //elemento com inflate do layout do dialog.

        // Colocando todos os códigos dentro do escopo apply, retirando as referencias a 'binding'
        // e simplificando a implementação.
        FormularioImagemBinding.inflate(LayoutInflater.from(context)).apply {

            // Verifica se a string recebida por parametro não é nula com o let.
            // Se não for, carrega a imagem e a url na view.
            urlDefault.let {
                formularioImagemImageview.tentaCarregarImagem(it)
                formularioImagemUrl.setText(it)
            }

            // Setando url no campo apenas devido não permitir colar uma url no emulador...
            formularioImagemUrl.setText(Constants.TESTE_IMAGEM)

            // Ação clique botão carregar.
            formularioImagemBotaoCarregar.setOnClickListener {
                val url = formularioImagemUrl.text.toString()
                formularioImagemImageview.tentaCarregarImagem(url)
            }

            // Cria e exibe a Dialog.
            AlertDialog.Builder(context)
                .setView(root) //aponta e faz o root.
                .setPositiveButton("Confirmar") { _, _ ->
                    val url = formularioImagemUrl.text.toString()
                    quandoImgCarregada(url)
                }
                .setNegativeButton("Cancelar") { _, _ -> }
                .show()
        }

    }

}