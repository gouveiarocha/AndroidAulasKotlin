package com.example.alura_formacao_androidkotlin_orgs.ui.activity

import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.alura_formacao_androidkotlin_orgs.R
import com.example.alura_formacao_androidkotlin_orgs.databinding.ActivityFormularioProdutoBinding
import com.example.alura_formacao_androidkotlin_orgs.utils.extensions.tentaCarregarImagem
import com.example.alura_formacao_androidkotlin_orgs.model.Produto
import com.example.alura_formacao_androidkotlin_orgs.dao.ProdutosDao
import com.example.alura_formacao_androidkotlin_orgs.ui.dialog.FormularioImagemDialog
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }

    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setTitle("Cadastrar Produto...")
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
        binding.activityFormularioProdutoImagem.setOnClickListener {
            FormularioImagemDialog(this).mostra(url) {
                url = it
                binding.activityFormularioProdutoImagem.tentaCarregarImagem(url)
            }
        }

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