package com.example.alura_formacao_androidkotlin_orgs.rapository

import com.example.alura_formacao_androidkotlin_orgs.model.Produto

class ProdutosDao {

    fun adiciona(produto: Produto){
        produtos.add(produto)
    }

    fun buscaTodos() : List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }

}