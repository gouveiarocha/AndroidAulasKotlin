package com.example.alura_formacao_androidkotlin_orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.alura_formacao_androidkotlin_orgs.databinding.ActivityListaProdutosBinding
import com.example.alura_formacao_androidkotlin_orgs.dao.ProdutosDao
import com.example.alura_formacao_androidkotlin_orgs.ui.adapter.ListaProdutosAdapter

class ListaProdutosActivity : AppCompatActivity() {

    private val dao = ProdutosDao()
    private val adapter = ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())

    //Binding da Activity
    private val binding by lazy {
        ActivityListaProdutosBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root) // root para a view - sem isso o binding não funciona!!!
        setTitle("Orgs...")
        configuraRecyclerView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
    }

    private fun configuraFab() {
        //val fab = findViewById<FloatingActionButton>(R.id.activity_lista_produtos_fab)
        val fab = binding.activityListaProdutosFab
        fab.setOnClickListener {
            vaiParaFormularioProduto()
        }
    }

    private fun vaiParaFormularioProduto() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        //val recyclerView = findViewById<RecyclerView>(R.id.activity_lista_produtos_recyclerView)
        val recyclerView = binding.activityListaProdutosRecyclerView
        recyclerView.adapter = adapter
    }

}