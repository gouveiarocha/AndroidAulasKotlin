package com.example.alura_formacao_androidkotlin_orgs.utils.extensions

import android.widget.ImageView
import coil.load
import com.example.alura_formacao_androidkotlin_orgs.R

//essa extension ficara responsavel por tentar carregar uma imagem usando a lib coil.

fun ImageView.tentaCarregarImagem(url: String? = null) {
    load(url) {
        //img durante carregamento
        //placeholder(R.drawable.placeholder)
        //fallback vai configurar uma imagem caso a imagem seja null.
        fallback(R.drawable.erro)
        //error vai configurar uma imagem caso ocorra algum erro ao carrega-la.
        error(R.drawable.erro)
    }
}