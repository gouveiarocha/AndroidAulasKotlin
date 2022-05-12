package com.example.alura_formacao_androidkotlin_orgs.ui.activity

import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.load
import com.example.alura_formacao_androidkotlin_orgs.R
import com.example.alura_formacao_androidkotlin_orgs.databinding.ActivityFormularioProdutoBinding
import com.example.alura_formacao_androidkotlin_orgs.databinding.FormularioImagemBinding
import com.example.alura_formacao_androidkotlin_orgs.model.Produto
import com.example.alura_formacao_androidkotlin_orgs.repository.ProdutosDao
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }

    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraBotaoSalvar()

        //o imageLoader é opcional e serve para dar suporte a gifs no request image do coil
        val imageLoader = ImageLoader.Builder(this)
            .components {
                if (SDK_INT >= 28) {
                    add(ImageDecoderDecoder.Factory())
                } else {
                    add(GifDecoder.Factory())
                }
            }
            .build()

        //val imgProduto = findViewById<ImageView>(R.id.activity_formulario_produto_imagem)
        binding.activityFormularioProdutoImagem.setOnClickListener(View.OnClickListener {
            val bindingFormularioImagem = FormularioImagemBinding.inflate(layoutInflater) //elemento com inflate do layout do dialog.

            //colocando uma url de forma estatica no campo pois nao esta aceitando colar no emulador
            //bindingFormularioImagem.formularioImagemUrl.setText("https://cdn-0.imagensemoldes.com.br/wp-content/uploads/2018/07/Imagem-de-Frutas-Laranja-12-PNG.png")
            bindingFormularioImagem.formularioImagemUrl.setText("https://i.gifer.com/Md0y.gif")

            //ação clique botão carregar
            bindingFormularioImagem.formularioImagemBotaoCarregar.setOnClickListener {
                val url = bindingFormularioImagem.formularioImagemUrl.text.toString()
                bindingFormularioImagem.formularioImagemImageview.load(url)
            }

            AlertDialog.Builder(this)
                .setView(bindingFormularioImagem.root) //aponta e faz o root.
                .setPositiveButton("Confirmar") { _, _ ->
                    url = bindingFormularioImagem.formularioImagemUrl.text.toString()
                    binding.activityFormularioProdutoImagem.load(url, imageLoader)
                }
                .setNegativeButton("Cancelar") { _, _ ->

                }
                .show()
        })

    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.activity_formulario_produto_botao_salvar)
        val dao = ProdutosDao()
        botaoSalvar.setOnClickListener {
            val produtoNovo = criaProduto()
            dao.adiciona(produtoNovo)
            finish()
        }
    }

    private fun criaProduto(): Produto {

        val campoNome = findViewById<EditText>(R.id.activity_formulario_produto_nome)
        val nome = campoNome.text.toString()
        val campoDescricao = findViewById<EditText>(R.id.activity_formulario_produto_descricao)
        val descricao = campoDescricao.text.toString()
        val campoValor = findViewById<EditText>(R.id.activity_formulario_produto_valor)
        val valorEmTexto = campoValor.text.toString()
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }

        return Produto(
            nome = nome,
            descricao = descricao,
            valor = valor,
            imagem = url
        )

    }
}